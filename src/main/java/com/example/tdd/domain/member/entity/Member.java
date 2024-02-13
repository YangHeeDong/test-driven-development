package com.example.tdd.domain.member.entity;

import com.example.tdd.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

    @NotEmpty(message = "아이디는 필수 입니다.")
    @Column(unique = true)
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password;

}
