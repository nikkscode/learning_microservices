package com.nikkscode.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default") //10s => 1000 calls to the sample api
    @Bulkhead(name = "default")
    public String sampleApi(){
        logger.info("Sample Api received");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dumy-url",String.class);
        return responseEntity.getBody();
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
