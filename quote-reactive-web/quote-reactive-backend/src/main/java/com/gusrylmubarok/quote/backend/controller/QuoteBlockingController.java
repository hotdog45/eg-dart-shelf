package com.gusrylmubarok.quote.backend.controller;

import com.gusrylmubarok.quote.backend.domain.Quote;
import com.gusrylmubarok.quote.backend.repository.QuoteMongoBlockingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteBlockingController {
    private static final int DELAY_PER_ITEM_MS = 100;
    private final QuoteMongoBlockingRepository quoteMongoBlockingRepository;
    public QuoteBlockingController(QuoteMongoBlockingRepository quoteMongoBlockingRepository) {
        this.quoteMongoBlockingRepository = quoteMongoBlockingRepository;
    }

    @GetMapping("/quotes-blocking")
    public Iterable<Quote> getQuotesBlocking() throws Exception {
        Thread.sleep(DELAY_PER_ITEM_MS * quoteMongoBlockingRepository.count());
        return quoteMongoBlockingRepository.findAll();
    }

    @GetMapping("/quotes-blocking-paged")
    public Iterable<Quote> getQuotesBlocking(final @RequestParam(name = "page") int page,
                                             final @RequestParam(name = "size") int size) throws Exception {
        Thread.sleep(DELAY_PER_ITEM_MS);
        return quoteMongoBlockingRepository.findAllByIdNotNullOrderByIdAsc(PageRequest.of(page, size));
    }
}
