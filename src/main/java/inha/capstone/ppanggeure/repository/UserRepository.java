package inha.capstone.ppanggeure.repository;

import inha.capstone.ppanggeure.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {
  Account findByUsername(String username);
  int countByUsername(String username);

  Optional<Account> findByProviderAndProviderId(String provider, String providerId);
}