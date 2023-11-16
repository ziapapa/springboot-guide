package com.spring.guide.external.sms;

import com.spring.guide.external.sms.dto.SmsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AmazonSmsClient implements SmsClient {

  @Override
  public void send(SmsRequest dto) {

    // amazon sms 호출...
  }
}
