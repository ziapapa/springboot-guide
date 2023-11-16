package com.spring.guide.external.sms;

import com.spring.guide.external.sms.dto.SmsRequest;

public interface SmsClient {

  void send(SmsRequest dto);

}
