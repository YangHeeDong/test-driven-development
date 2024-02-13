package com.example.tdd.domain.member;

import com.example.tdd.domain.member.entity.Member;
import com.example.tdd.domain.member.repository.MemberRepository;
import com.example.tdd.domain.member.service.MemberService;
import com.example.tdd.global.response.ErrorCode;
import com.example.tdd.global.response.ResData;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Mockito를 이용한 단위테스트
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    private final String loginId = "user1";
    private final String password = "test-password";

    @Test
    public void 회원가입실패_이미존재(){

        // given
        doReturn(Member.builder().build()).when(memberRepository).findByLoginId(loginId);

        // when
        final ResData resData = assertThrows(ResData.class, () -> memberService.addMember(loginId, password));

        // then
        assertThat(resData.getErrorCode()).isEqualTo(ErrorCode.DUPLICATED_MEMBER_REGISTER);
    }

}
