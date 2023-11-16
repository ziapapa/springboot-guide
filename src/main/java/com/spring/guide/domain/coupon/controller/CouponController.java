package com.spring.guide.domain.coupon.controller;

import com.spring.guide.domain.coupon.service.CouponUseService;
import com.spring.guide.domain.coupon.repository.CouponFindDao;
import com.spring.guide.domain.coupon.model.CouponCode;
import com.spring.guide.domain.coupon.dto.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponController {


  private final CouponFindDao couponFindDao;
    private final CouponUseService couponUseService;

    @GetMapping("/{code}")
    public CouponResponse getCoupon(@PathVariable final String code) {
      return new CouponResponse(couponFindDao.findByCode(CouponCode.of(code)));
    }

    @PutMapping("/{code}")
    public void useCoupon(@PathVariable final String code) {
        couponUseService.use(CouponCode.of(code));
    }
}
