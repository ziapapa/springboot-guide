package com.spring.guide.test.setup.domain;

import com.spring.guide.domain.coupon.CouponBuilder;
import com.spring.guide.domain.coupon.repository.CouponRepository;
import com.spring.guide.domain.coupon.model.Coupon;
import com.spring.guide.test.config.TestProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(TestProfile.TEST)
@RequiredArgsConstructor
@Component
public class CouponSetup {

    private final CouponRepository couponRepository;

    public Coupon save() {
        final Coupon coupon = CouponBuilder.build();
        return couponRepository.save(coupon);
    }

    public List<Coupon> save(int count) {
        List<Coupon> coupons = new ArrayList<>();
        IntStream.range(0, count).forEach((i) -> coupons.add(CouponBuilder.build()));
        return couponRepository.saveAll(coupons);
    }
}
