package com.spring.guide;

import com.spring.guide.domain.member.model.Member;
import com.spring.guide.domain.member.dto.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleApi {

  private final RestTemplate localTestTemplate;

  @PostMapping("/local-sign-up")
  public Member test(@RequestBody @Valid final SignUpRequest dto) {
    final ResponseEntity<Member> responseEntity = localTestTemplate
        .postForEntity("/members", dto, Member.class);

//    final HttpStatus statusCode = responseEntity.getStatusCode();

//    if(statusCode.is2xxSuccessful()){
    // 성공...
//    }else{
    /// 실패...
//    }

    final Member member = responseEntity.getBody();
    return member;
  }
}
