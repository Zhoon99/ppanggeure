package inha.capstone.ppanggeure.service;

import inha.capstone.ppanggeure.dto.BreadDto;
import inha.capstone.ppanggeure.dto.MenuImgDto;
import inha.capstone.ppanggeure.entity.Bread;
import inha.capstone.ppanggeure.entity.MenuImg;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface BreadService {

    Long register(BreadDto breadDto);

    default Map<String, Object> dtoToEntity(BreadDto breadDto) {
        Map<String, Object> entityMap = new HashMap<>();

        ModelMapper modelMapper = new ModelMapper();
        Bread bread = modelMapper.map(breadDto, Bread.class);

        entityMap.put("bread", bread);

        List<MenuImgDto> menuImgDtoList = breadDto.getImageDtoList();

        if (menuImgDtoList != null && menuImgDtoList.size() > 0) {
            List<MenuImg> menuImgList = menuImgDtoList.stream().map(menuImgDto -> {
                MenuImg menuImg = MenuImg.builder()
                        .folderPath(menuImgDto.getFolderPath())
                        .imgName(menuImgDto.getImgName())
                        .uuid(menuImgDto.getUuid())
                        .bread(bread)
                        .build();
                return menuImg;
            }).collect(Collectors.toList());

            entityMap.put("imgList", menuImgList);
        }
        return entityMap;
    }
}
