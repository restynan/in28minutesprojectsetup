package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.models.ExchangeValue;

import com.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

//http://localhost:8000/currency-exchange/from/USD/to/INR
//calling through the zuul gate way
//http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
@RestController
public class CurrencyExchangeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
   private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;



    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to){
      ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from,to);

      exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

      logger.info("{}",exchangeValue);
      return  exchangeValue;
    }
}
