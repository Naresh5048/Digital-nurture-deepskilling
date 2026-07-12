package com.cognizant.apigateway.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Intercept and print the path of every single request hitting our system
        LOGGER.info("Intercepted Global Request Traffic -> Path target URI: {}",
                exchange.getRequest().getPath());

        // Pass the execution along down the filter routing chains
        return chain.filter(exchange);
    }
}