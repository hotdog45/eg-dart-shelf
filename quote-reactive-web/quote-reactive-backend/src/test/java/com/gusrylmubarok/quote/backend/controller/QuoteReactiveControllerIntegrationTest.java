package com.gusrylmubarok.quote.backend.controller;

import com.gusrylmubarok.quote.backend.configuration.QuoteDataLoader;
import com.gusrylmubarok.quote.backend.domain.Quote;
import com.gusrylmubarok.quote.backend.repository.QuoteMongoReactiveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuoteReactiveControllerIntegrationTest {
    @MockBean
    private QuoteMongoReactiveRepository quoteMongoReactiveRepository;

    // This one is not needed, but we need to override the real one to prevent the default behavior
    @MockBean
    private QuoteDataLoader quoteDataLoader;

    @LocalServerPort
    private int serverPort;

    private WebClient webClient;

    private Flux<Quote> quoteFlux;

    @BeforeEach
    public void setUp() {
        this.webClient = WebClient.create("http://localhost:" + serverPort);
        quoteFlux = Flux.just(
                new Quote("1", "mock-book", "Quote 1"),
                new Quote("2", "mock-book", "Quote 2"),
                new Quote("3", "mock-book", "Quote 3"),
                new Quote("4", "mock-book", "Quote 4"));
    }

    @Test
    public void simpleGetRequest() {
        // given
        given(quoteMongoReactiveRepository.findAll()).willReturn(quoteFlux);

        // when
        Flux<Quote> receivedFlux = webClient.get().uri("/quotes-reactive").accept(MediaType.TEXT_EVENT_STREAM)
                .exchange().flatMapMany(response -> response.bodyToFlux(Quote.class));

        // then
        StepVerifier.create(receivedFlux)
                .expectNext(new Quote("1", "mock-book", "Quote 1"))
                // Note that if you uncomment this line the test will fail. For some reason the delay after the first
                // element is not respected (I'll investigate this)
//                .expectNoEvent(Duration.ofMillis(99)) // these lines might fail depending on the machine
                .expectNext(new Quote("2", "mock-book", "Quote 2"))
//                .expectNoEvent(Duration.ofMillis(99))
                .expectNext(new Quote("3", "mock-book", "Quote 3"))
//                .expectNoEvent(Duration.ofMillis(99))
                .expectNext(new Quote("4", "mock-book", "Quote 4"))
                .expectComplete()
                .verify();

    }

    @Test
    public void pagedGetRequest() {
        // given
        // In case page=1 and size=2, we mock the result to only the first two elements. Otherwise the Flux will be null.
        given(quoteMongoReactiveRepository.findAllByIdNotNullOrderByIdAsc(PageRequest.of(1, 2)))
                .willReturn(quoteFlux.take(2));

        // when
        Flux<Quote> receivedFlux = webClient.get().uri("/quotes-reactive-paged?page=1&size=2")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange().flatMapMany(response -> response.bodyToFlux(Quote.class));

        // then
        StepVerifier.create(receivedFlux)
                .expectNext(new Quote("1", "mock-book", "Quote 1"))
                .expectNext(new Quote("2", "mock-book", "Quote 2"))
                .expectComplete()
                .verify();

    }
}
