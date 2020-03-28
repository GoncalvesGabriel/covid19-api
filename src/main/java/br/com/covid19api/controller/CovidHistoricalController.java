package br.com.covid19api.controller;

import br.com.covid19api.service.CovidHistoricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historicos")
public class CovidHistoricalController {

    @Autowired
    private CovidHistoricalService service;

}
