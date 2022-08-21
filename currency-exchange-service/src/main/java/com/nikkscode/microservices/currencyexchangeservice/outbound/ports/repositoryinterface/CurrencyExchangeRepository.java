package com.nikkscode.microservices.currencyexchangeservice.outbound.ports.repositoryinterface;

import com.nikkscode.microservices.currencyexchangeservice.businesslogic.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
