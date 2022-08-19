package com.gusrylmubarok.quote.backend.repository;

import com.gusrylmubarok.quote.backend.domain.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface QuoteMongoReactiveRepository extends ReactiveSortingRepository<Quote, String> {
    Flux<Quote> findAllByIdNotNullOrderByIdAsc(final Pageable page);
}
