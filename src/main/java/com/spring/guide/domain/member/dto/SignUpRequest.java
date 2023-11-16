package com.spring.guide.domain.member.dto;

import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.member.model.ReferralCode;
import com.spring.guide.domain.model.Email;
import com.spring.guide.domain.model.Name;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SignUpRequest {

    @Valid
    private Email email;

    @Valid
    private Name name;

    SignUpRequest(@Valid Email email, @Valid Name name) {
        this.email = email;
        this.name = name;
    }

    public Member toEntity(final ReferralCode referralCode) {
        return Member.builder()
                .name(name)
                .email(email)
                .referralCode(referralCode)
                .build();
    }
}
