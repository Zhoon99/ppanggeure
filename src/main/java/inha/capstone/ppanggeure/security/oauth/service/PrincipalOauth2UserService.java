package inha.capstone.ppanggeure.security.oauth.service;

import inha.capstone.ppanggeure.entity.Account;
import inha.capstone.ppanggeure.entity.Role;
import inha.capstone.ppanggeure.repository.RoleRepository;
import inha.capstone.ppanggeure.repository.UserRepository;
import inha.capstone.ppanggeure.security.form.service.UserPrincipal;
import inha.capstone.ppanggeure.security.oauth.user.GoogleUserInfo;
import inha.capstone.ppanggeure.security.oauth.user.NaverUserInfo;
import inha.capstone.ppanggeure.security.oauth.user.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Override
	@Transactional
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		OAuth2User oAuth2User = super.loadUser(userRequest); // google 의 회원 프로필 조회
		return processOAuth2User(userRequest, oAuth2User);
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			System.out.println("구글 로그인 요청~~");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")){
			System.out.println("네이버 로그인 요청~~");
			oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
		} else {
			System.out.println("우리는 구글과 페이스북만 지원해요 ㅎㅎ");
		}

		Optional<Account> userOptional =
				userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());

		Account account;
		if (userOptional.isPresent()) {
			account = userOptional.get();
			account.setEmail(oAuth2UserInfo.getEmail());
			userRepository.save(account);
		} else {
			account = createOAuth2User(oAuth2UserInfo);
		}

		List<GrantedAuthority> collect = account.getUserRoles()
				.stream()
				.map(userRole -> userRole.getRoleName())
				.collect(Collectors.toSet())
				.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		return new UserPrincipal(account, collect, oAuth2User.getAttributes());
	}

	private Account createOAuth2User(OAuth2UserInfo oAuth2UserInfo) {

		Account account = userRepository.save(Account.builder()
				.username(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId())
				.email(oAuth2UserInfo.getEmail())
				.provider(oAuth2UserInfo.getProvider())
				.providerId(oAuth2UserInfo.getProviderId())
				.build());

		Role role = roleRepository.findByRoleName("ROLE_USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);

		account.setUserRoles(roles);

		return account;
	}
}
