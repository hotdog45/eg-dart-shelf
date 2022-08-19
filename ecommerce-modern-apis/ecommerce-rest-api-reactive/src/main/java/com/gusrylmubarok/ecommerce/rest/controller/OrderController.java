package com.gusrylmubarok.ecommerce.rest.controller;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import com.gusrylmubarok.ecommerce.rest.OrderApi;
import com.gusrylmubarok.ecommerce.rest.hateoas.OrderRepresentationModelAssembler;
import com.gusrylmubarok.ecommerce.rest.model.NewOrder;
import com.gusrylmubarok.ecommerce.rest.model.Order;
import com.gusrylmubarok.ecommerce.rest.service.OrderService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class OrderController implements OrderApi {
  private final OrderRepresentationModelAssembler assembler;
  private OrderService service;

  public OrderController(OrderService service, OrderRepresentationModelAssembler assembler) {
    this.service = service;
    this.assembler = assembler;
  }

  @Override
  public Mono<ResponseEntity<Order>> addOrder(@Valid Mono<NewOrder> newOrder,
      ServerWebExchange exchange) {
    return service.addOrder(newOrder.cache())
        .zipWhen(x -> service.updateMapping(x))
        .map(t -> status(HttpStatus.CREATED).body(assembler.entityToModel(t.getT2(), exchange)))
        .defaultIfEmpty(notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Flux<Order>>> getOrdersByCustomerId(@NotNull @Valid String customerId,
      ServerWebExchange exchange) {
    return Mono
        .just(ok(assembler.toListModel(service.getOrdersByCustomerId(customerId), exchange)));
  }

  @Override
  public Mono<ResponseEntity<Order>> getByOrderId(String id, ServerWebExchange exchange) {
    return service.getByOrderId(id).map(o -> assembler.entityToModel(o, exchange))
        .map(ResponseEntity::ok)
        .defaultIfEmpty(notFound().build());
  }
}
