package inha.capstone.ppanggeure.controller.editor;

import inha.capstone.ppanggeure.dto.BreadDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/editor")
public class BreadRegisterController {

    @GetMapping(value="/breadRegister")
    public String breadRegister() throws Exception {
        return "/editor/breadRegister";
    }

    @PostMapping(value="/breadRegister", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void map(BreadDto breadDto) throws Exception {
        System.out.println(breadDto.toString());
    }

}
