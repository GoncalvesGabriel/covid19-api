package br.com.covid19api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
public class CovidHistoricalOutput {

    private String country;

    private String province;

    private CovidHistoricalTimeline timeline;

    public Set<Map.Entry<String, Integer>> getCases() {
        return this.timeline.getCases().entrySet();
    }

    public Set<Map.Entry<String, Integer>> getDeaths() {
        return this.timeline.getDeaths().entrySet();
    }

    @Data
    public static class CovidHistoricalTimeline {

        private Map<String, Integer> cases;

        private Map<String, Integer> deaths;

    }
}
