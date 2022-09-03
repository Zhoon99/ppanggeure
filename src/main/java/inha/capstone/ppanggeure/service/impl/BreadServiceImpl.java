package inha.capstone.ppanggeure.service.impl;

import inha.capstone.ppanggeure.dto.BreadDto;
import inha.capstone.ppanggeure.dto.MenuImgDto;
import inha.capstone.ppanggeure.entity.Account;
import inha.capstone.ppanggeure.entity.Bread;
import inha.capstone.ppanggeure.entity.MenuImg;
import inha.capstone.ppanggeure.repository.BreadRepository;
import inha.capstone.ppanggeure.repository.MenuImgRepository;
import inha.capstone.ppanggeure.service.BreadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BreadServiceImpl implements BreadService {

    private final BreadRepository breadRepository;

    private final MenuImgRepository menuImgRepository;

    @Override
    @Transactional
    public Long register(BreadDto breadDto) {

        Map<String, Object> entityMap = dtoToEntity(breadDto);
        Bread bread = (Bread) entityMap.get("bread");
        List<MenuImg> menuImgList = (List<MenuImg>) entityMap.get("imgList");

        breadRepository.save(bread);

        menuImgList.forEach(menuImg -> {
            menuImgRepository.save(menuImg);
        });

        return bread.getId();
    }
}
