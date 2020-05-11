package com.in28minutes.microservices.currencyconversionservice.controllers;

import com.in28minutes.microservices.currencyconversionservice.models.CurrencyConverterBean;
import com.in28minutes.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
// calling the currency coversion service through zuul
//http://localhost:8765/currency-conversion-service/currency-converterfeign/from/USD/to/INR/quantity/7000
@RestController
public class currencyCoverterController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;


   // using feign
    @GetMapping("/currency-converterfeign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterBean convertCurrencyfeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConverterBean response= currencyExchangeServiceProxy.retrieveExchangeValue(from,to);

        logger.info("{}",response);
        return new CurrencyConverterBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }












    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
        public CurrencyConverterBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){



        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);


        ResponseEntity<CurrencyConverterBean> responseEntity=
                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from//{from}/to/{to}",
                CurrencyConverterBean.class,uriVariables);

        CurrencyConverterBean response= responseEntity.getBody();
        return new CurrencyConverterBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
        }
}
