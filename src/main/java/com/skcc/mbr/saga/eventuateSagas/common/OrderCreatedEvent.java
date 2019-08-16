package com.skcc.mbr.saga.eventuateSagas.common;
import io.eventuate.tram.events.common.DomainEvent;

public class OrderCreatedEvent implements OrderEvent {

  private OrderDetails orderDetails;

  public OrderCreatedEvent() {
  }

  public OrderCreatedEvent(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }
}
