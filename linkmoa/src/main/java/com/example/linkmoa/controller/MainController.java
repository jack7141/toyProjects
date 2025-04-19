package com.example.linkmoa.controller;

import com.example.linkmoa.domain.MemberEntity;
import com.example.linkmoa.dto.ItemDTO;
import com.example.linkmoa.dto.RespDTO;
import com.example.linkmoa.repository.MemberRepository;
import com.example.linkmoa.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {
    @Autowired
    private MainService mainService;



    @GetMapping("/")
    public String main(){
        log.info("main");
        return "Hello World";
    }

    @PostMapping("/user")
    public ItemDTO user(@RequestBody ItemDTO itemDTO) {
        log.info("조회하려는 UserID: " + itemDTO.getUserId());
        Long userId = Long.parseLong(itemDTO.getUserId());
        ItemDTO res = mainService.getItemById(userId);
        return res;
    }
}
