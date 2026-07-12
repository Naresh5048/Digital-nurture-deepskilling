package com.cognizant.employeecomposite.proxy;

import com.cognizant.employeecomposite.model.CountryDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface ExchangeClusterProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    org.json.JSONObject retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );
}