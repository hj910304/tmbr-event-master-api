package com.skcc.mbr.config;

import io.eventuate.tram.consumer.common.TramNoopDuplicateMessageDetectorConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.optimisticlocking.OptimisticLockingDecoratorConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.skcc.mbr.saga.eventuateSagas.service.EntryEventConsumer;
import com.skcc.mbr.saga.eventuateSagas.service.MasterSagaService;

@Configuration
@Import({TramJdbcKafkaConfiguration.class,
        TramEventsPublisherConfiguration.class,
        TramEventSubscriberConfiguration.class,
        OptimisticLockingDecoratorConfiguration.class})
@EnableJpaRepositories
@EnableAutoConfiguration
public class MasterInfoConfiguration {
	
	@Bean
	public EntryEventConsumer entryEventConsumer() {
		return new EntryEventConsumer();
	}
	
	@Bean
	public DomainEventDispatcher domainEventDispatcher(EntryEventConsumer entryEventCousumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {		
		return domainEventDispatcherFactory.make("Master:EntryServiceEvents", entryEventCousumer.domainEventHandlers() );
	}

	@Bean
	public MasterSagaService mastersagaService() {
		return new MasterSagaService();
	}
	
//	@Bean
//	public MasterSagaService masterSagaService(DomainEventPublisher domainEventPublisher, EventInfoRepository eventInfoRepository) {
//		return new MasterSagaService(domainEventPublisher, eventInfoRepository);
//	}
	
}
