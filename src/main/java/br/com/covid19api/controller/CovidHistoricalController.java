package br.com.covid19api.controller;

import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.provider.receivers.CoronaLmaoProvider;
import br.com.covid19api.service.CovidHistoricalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("historicos")
public class CovidHistoricalController {

    @Autowired
    private CovidHistoricalService service;

    @Autowired
    private CoronaLmaoProvider provider;

    @ApiOperation(value = "Apresenta informações dos países para comparativo", consumes = "application/json",httpMethod = "GET")
    @ApiResponse(code = 200, message = "Busca do comparativo realizado com sucesso")
    @ApiParam(value = "Nomes dos países para comparação")
    @GetMapping
    public List<CovidHistoricalComparison> getComparison(@RequestParam("paises") List<String> countries) {
        return this.service.getComparison(countries);
    }

}
