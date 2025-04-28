package com.tektonlabs.percentagecalculationapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class PercentageService {

    private final WebClient.Builder webClientBuilder;

    private static final Logger logger = LoggerFactory.getLogger(PercentageService.class);

    public PercentageService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Cacheable(value = "percentageCache", key = "'percentage'", unless = "#result == null", cacheManager = "cacheManager")
    public double getPercentageFromProvider() {
        double percentage = 0.0;

            try {
                WebClient webClient = this.webClientBuilder.build();
                JsonNode block = webClient.method(HttpMethod.GET)
                        .uri("http://localhost:8081/api/v1/percentage")
                        .retrieve()
                        .bodyToMono(JsonNode.class)
                        .block();
                if (block == null) {
                    throw new RuntimeException("Response is null");
                }
                percentage =  block.get("percentage").asDouble();
            }catch(Exception e){
                logger.error(e.getMessage());
            }
            return percentage;
    }

}



