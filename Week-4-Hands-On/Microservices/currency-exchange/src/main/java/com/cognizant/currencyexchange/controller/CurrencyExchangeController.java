package com.cognizant.currencyexchange.controller;

import com.cognizant.currencyexchange.model.ExchangeValue;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue;

        if (from.equalsIgnoreCase("USD") && to.equalsIgnoreCase("INR")) {
            exchangeValue = new ExchangeValue(1001L, from, to, BigDecimal.valueOf(80));
        } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("INR")) {
            exchangeValue = new ExchangeValue(1002L, from, to, BigDecimal.valueOf(90));
        } else {
            exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(1));
        }

        int currentPort = Integer.parseInt(environment.getProperty("local.server.port"));
        exchangeValue.setPort(currentPort);

        return exchangeValue;
    }
}