package com.spring.guide.domain.member.serivce;

import com.spring.guide.domain.member.repository.MemberFindDao;
import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.member.dto.MemberProfileUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberProfileService {

  private final MemberFindDao memberFindDao;

    public Member update(final long memberId, final MemberProfileUpdate dto) {
      final Member member = memberFindDao.findById(memberId);
        member.updateProfile(dto.getName());
        return member;
    }

}
