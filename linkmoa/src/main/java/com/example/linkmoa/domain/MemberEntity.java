package com.example.linkmoa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "name")
    private String name;

    private String password;

    @Column(nullable = false)
    private String role;

    @Column(name = "email")
    private String email;

}
