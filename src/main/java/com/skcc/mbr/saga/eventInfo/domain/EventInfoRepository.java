package com.skcc.mbr.saga.eventInfo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventInfoRepository extends JpaRepository<EventInfo,Long>{
	public EventInfo findAllByEventId(Long eventId);
}
