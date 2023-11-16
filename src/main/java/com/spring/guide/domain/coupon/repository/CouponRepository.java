package com.spring.guide.domain.coupon.repository;

import com.spring.guide.domain.coupon.model.Coupon;
import com.spring.guide.domain.coupon.model.CouponCode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCode(CouponCode code);

    boolean existsByCode(CouponCode code);

}
