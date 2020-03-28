package br.com.covid19api.dto;

import lombok.Data;

@Data
public class CovidHistoricalComparison {

    private String country;

    private String firstCaseDate;

    private String firstDeathDate;

    private Integer currentCases;

}
