package br.com.covid19api.controller;

import br.com.covid19api.provider.receivers.CoronaLmaoConsumer;
import br.com.covid19api.service.CovidHistoricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historicos")
public class CovidHistoricalController {

    @Autowired
    private CovidHistoricalService service;

    @Autowired
    private CoronaLmaoConsumer receiver;

    @GetMapping("{country}")
    public void getHistorical(@PathVariable("country") String country){
        receiver.consume(country);
    }


}
