package com.example.linkmoa.controller;

import com.example.linkmoa.dto.ItemDTO;
import com.example.linkmoa.dto.RespDTO;
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
    public RespDTO user(@RequestBody ItemDTO itemDTO) {
        boolean is_success = mainService.registerItem(itemDTO);
        if (is_success) {
            RespDTO respDTO =  new RespDTO();
             log.info("itemDTO: {}", itemDTO);
            respDTO.setCode(200);
            respDTO.setMsg("success");
            return respDTO;
        }
        RespDTO respDTO =  new RespDTO();
        respDTO.setCode(400);
        respDTO.setMsg("failed");
        return respDTO;
    }
}
