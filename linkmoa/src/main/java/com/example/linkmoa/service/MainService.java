package com.example.linkmoa.service;

import com.example.linkmoa.domain.MemberEntity;
import com.example.linkmoa.dto.ItemDTO;
import com.example.linkmoa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean registerItem(ItemDTO itemDTO) {
        return false;
    }

    public ItemDTO getItemById(long id) {
        log.info("조회한 ID: {}", id);
        MemberEntity memberEntity = memberRepository.findByMemberId(id)
                .orElseThrow(() -> new RuntimeException("조회하신 사용자를 찾을 수 없습니다: " + id));
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(memberEntity.getName());
        itemDTO.setUserId(memberEntity.getEmail());
        itemDTO.setPassword(memberEntity.getPassword());
        return itemDTO;
    }
}
