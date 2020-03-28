package br.com.covid19api.controller;

import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.provider.receivers.CoronaLmaoProvider;
import br.com.covid19api.service.CovidHistoricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("historicos")
public class CovidHistoricalController {

    @Autowired
    private CovidHistoricalService service;

    @Autowired
    private CoronaLmaoProvider provider;

    @GetMapping("{country}")
    public void getHistorical(@PathVariable("country") String country){
        provider.provideHistorical(country);
    }

    @GetMapping("comparativo")
    public List<CovidHistoricalComparison> getComparison(@RequestParam("paises") List<String> countries) {
        return this.service.getComparison(countries);
    }

}
