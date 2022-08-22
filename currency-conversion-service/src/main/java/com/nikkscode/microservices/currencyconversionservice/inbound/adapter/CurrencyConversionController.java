package com.nikkscode.microservices.currencyconversionservice.inbound.adapter;

import com.nikkscode.microservices.currencyconversionservice.busineslogic.CurrencyConversion;
import com.nikkscode.microservices.currencyconversionservice.outbound.proxy.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @Autowired
    CurrencyExchangeProxy proxy;

    Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        logger.info("retrieveExChangeValue called with {} to {}, quantity {}", from, to, quantity);
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(),
                from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment());
    }
}
