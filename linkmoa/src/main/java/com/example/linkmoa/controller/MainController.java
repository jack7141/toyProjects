package com.example.linkmoa.controller;

import com.example.linkmoa.dto.ItemDTO;
import com.example.linkmoa.dto.RespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/")
    public String main(){
        log.info("main");
        return "Hello World";
    }

    @PostMapping("/user")
    public RespDTO user(@RequestBody ItemDTO itemDTO) {
        log.info("itemDTO: {}", itemDTO);
        RespDTO respDTO =  new RespDTO();
        respDTO.setCode(200);
        respDTO.setMsg("success");
        return respDTO;
    }
}
