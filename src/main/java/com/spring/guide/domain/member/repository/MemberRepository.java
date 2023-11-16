package com.spring.guide.domain.member.repository;

import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.member.model.ReferralCode;
import com.spring.guide.domain.model.Email;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberSupportRepository,
    MemberPredicateExecutor<Member> {

  Optional<Member> findByEmail(Email email);

  boolean existsByEmail(Email email);

  boolean existsByReferralCode(ReferralCode referralCode);

}
