package com.skcc.mbr.saga.domain.coupon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CouponRepository extends JpaRepository<Coupon,Long>{
	List<Coupon> findAllByEventId(Long event_Id); 
}
