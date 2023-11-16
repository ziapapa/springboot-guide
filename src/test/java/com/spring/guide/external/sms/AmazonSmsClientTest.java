package com.spring.guide.external.sms;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.spring.guide.external.sms.dto.SmsRequest;
import org.junit.Test;

public class AmazonSmsClientTest {

  @Test
  public void send_test() {
    final SmsClient smsClient = new AmazonSmsClient();
    smsClient.send(new SmsRequest());
  }
}