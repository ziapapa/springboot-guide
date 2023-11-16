package com.spring.guide.domain.member.serivce;

import com.spring.guide.domain.member.repository.MemberRepository;
import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.member.model.ReferralCode;
import com.spring.guide.domain.member.dto.SignUpRequest;
import com.spring.guide.domain.member.exception.EmailDuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberRepository memberRepository;

    public Member doSignUp(final SignUpRequest dto) {

        if (memberRepository.existsByEmail(dto.getEmail())) {
            throw new EmailDuplicateException(dto.getEmail());
        }

        final ReferralCode referralCode = generateUniqueReferralCode();
        return memberRepository.save(dto.toEntity(referralCode));
    }

    private ReferralCode generateUniqueReferralCode() {
        ReferralCode referralCode;
        do {
            referralCode = ReferralCode.generateCode();
        } while (memberRepository.existsByReferralCode(referralCode));

        return referralCode;
    }

}
