package com.in28minutes.microservices.currencyconversionservice.proxy;

import com.in28minutes.microservices.currencyconversionservice.models.CurrencyConverterBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name ="currency-exchange-service",url ="localhost:8000")
//@FeignClient(name ="currency-exchange-service")
//
//feign should not connect directly wiith the currency exchage service,it should first go through zuul gateway
@FeignClient(name ="netflix-zuul-api-gateway-server")

//using ribbon to get the remote url
@RibbonClient(name ="currency-exchange-service")

public interface CurrencyExchangeServiceProxy {

   // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConverterBean retrieveExchangeValue(@PathVariable ("from")String from, @PathVariable("to")String to);
}



//http://localhost:8100/currency-converterfeign/from/USD/to/INR/quantity/1000