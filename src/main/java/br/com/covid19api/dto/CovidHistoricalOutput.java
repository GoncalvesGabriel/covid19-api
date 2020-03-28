package br.com.covid19api.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CovidHistoricalOutput {

    private String country;

    private String province;

    private CovidHistoricalTimeline timeline;

    @Data
    private static class CovidHistoricalTimeline {

        private Map<String, Integer> cases;

        private Map<String, Integer> deaths;
    }
}
