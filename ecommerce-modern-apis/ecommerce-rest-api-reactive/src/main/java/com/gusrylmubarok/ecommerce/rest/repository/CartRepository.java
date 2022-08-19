package com.gusrylmubarok.ecommerce.rest.repository;

import com.gusrylmubarok.ecommerce.rest.entity.CartEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CartRepository extends ReactiveCrudRepository<CartEntity, UUID> {
  @Query("select c.* from ecomm.cart c join ecomm.user u on c.user_id=u.id where u.id = :customerId")
  Mono<CartEntity> findByCustomerId(String customerId);
}
