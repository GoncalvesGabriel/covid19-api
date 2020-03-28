package br.com.covid19api.controller;

import br.com.covid19api.provider.receivers.CoronaLmaoConsumer;
import br.com.covid19api.service.CovidHistoricalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api()
@RestController
@RequestMapping("historicos")
public class CovidHistoricalController {

    @Autowired
    private CovidHistoricalService service;

    @Autowired
    private CoronaLmaoConsumer receiver;

    @GetMapping("{country}")
    @ApiOperation(value = "Apresenta informações do país em comparativo com outros país passado", consumes = "application/json",httpMethod = "GET")
    @ApiResponse(code = 200, message = "Busca do comparativo realizado com sucesso")
    public void getHistorical(
        @PathVariable("country")
        @ApiParam(value = "Nomes dos países para comparação")
        String country){
        receiver.consume(country);
    }


}
