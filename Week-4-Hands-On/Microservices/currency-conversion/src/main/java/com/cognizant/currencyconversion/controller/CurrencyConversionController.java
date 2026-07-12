package com.cognizant.currencyconversion.controller;

import com.cognizant.currencyconversion.model.CurrencyConversion;
import com.cognizant.currencyconversion.proxy.CurrencyExchangeProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeProxy proxy;

    public CurrencyConversionController(CurrencyExchangeProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversion response = proxy.retrieveExchangeValue(from, to);

        BigDecimal totalAmount = quantity.multiply(response.getConversionMultiple());

        return new CurrencyConversion(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity,
                totalAmount,
                response.getPort()
        );
    }
}