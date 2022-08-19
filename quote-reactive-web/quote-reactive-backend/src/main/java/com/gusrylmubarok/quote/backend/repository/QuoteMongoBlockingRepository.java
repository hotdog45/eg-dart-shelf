package com.gusrylmubarok.quote.backend.repository;

import com.gusrylmubarok.quote.backend.domain.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuoteMongoBlockingRepository extends PagingAndSortingRepository<Quote, String> {
    List<Quote> findAllByIdNotNullOrderByIdAsc(final Pageable page);
}
