package com.example.tdd.domain.member.repository;

import com.example.tdd.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByLoginId(String user1);
}
