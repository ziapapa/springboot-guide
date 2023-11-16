package com.spring.guide.domain.member.repository;

import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.model.Email;
import java.util.List;

public interface MemberSupportRepository {

  List<Member> searchByEmail(Email email);
}
