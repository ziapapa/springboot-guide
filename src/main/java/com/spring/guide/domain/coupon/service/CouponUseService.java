package com.spring.guide.domain.coupon.service;

import com.spring.guide.domain.coupon.repository.CouponFindDao;
import com.spring.guide.domain.coupon.model.Coupon;
import com.spring.guide.domain.coupon.model.CouponCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponUseService {

  private final CouponFindDao couponFindDao;

    public void use(final CouponCode code) {
      final Coupon coupon = couponFindDao.findByCode(code);
        coupon.use();
    }
}
