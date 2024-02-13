package com.example.tdd.domain.member;

import com.example.tdd.domain.member.entity.Member;
import com.example.tdd.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    @Transactional // 테스트 완료 후 rollback
    @DisplayName("회원 정보 저장")
    void 회원정보저장() {

        // given
        final Member member = Member.builder()
                .loginId("user1")
                .password(passwordEncoder.encode("1234"))
                .build();
        // when
        final Member result = memberRepository.save(member);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getLoginId()).isEqualTo("user1");
        assertThat(result.getPassword()).isNotNull();
        assertThat(result.getCreateDate()).isNotNull();
        assertThat(result.getModifiedDate()).isNotNull();
    }

    @Test
    @Transactional
    @DisplayName("로그인아이디로 유저 찾기")
    void 로그인아이디로유저찾기() {

        // given
        final Member member = Member.builder()
                .loginId("user1")
                .password(passwordEncoder.encode("1234"))
                .build();
        // when
        memberRepository.save(member);
        final Member result = memberRepository.findByLoginId("user1");

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getLoginId()).isEqualTo("user1");
        assertThat(result.getPassword()).isNotNull();
        assertThat(result.getCreateDate()).isNotNull();
        assertThat(result.getModifiedDate()).isNotNull();
    }
}
