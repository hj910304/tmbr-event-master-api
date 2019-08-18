package com.skcc.mbr.saga.eventuateSagas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.skcc.mbr.saga.eventInfo.domain.event.EventInfoRepository;

import io.eventuate.tram.events.publisher.DomainEventPublisher;

//@Transactional
public class MasterSagaService {
	
	@Autowired
	private DomainEventPublisher domainEventPublisher;
	
	@Autowired
	private EventInfoRepository eventInfoRepository;

//	public MasterSagaService(DomainEventPublisher domainEventPublisher, EventInfoRepository eventInfoRepository){
//		this.domainEventPublisher = domainEventPublisher;
//		this.eventInfoRepository = eventInfoRepository;
//	}
}
