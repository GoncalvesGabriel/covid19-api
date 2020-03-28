package br.com.covid19api.consumer.impl;

import br.com.covid19api.consumer.CovidHistoricalConsumer;
import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.dto.CovidHistoricalOutput;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ComparisonCovidHistoricalConsumer implements CovidHistoricalConsumer<CovidHistoricalComparison> {

    @Override
    public CovidHistoricalComparison consume(CovidHistoricalOutput dto) {
        CovidHistoricalComparison comparison = new CovidHistoricalComparison();

        Optional<Map.Entry<String, Integer>> firstCase = dto.getCases().stream().filter(e -> e.getValue() > 0).findFirst();
        Optional<Map.Entry<String, Integer>> firstDeath = dto.getDeaths().stream().filter(e -> e.getValue() > 0).findFirst();

        comparison.setCountry(dto.getCountry());
        firstCase.ifPresent(f -> comparison.setFirstCaseDate(f.getKey()));
        firstDeath.ifPresent(f -> comparison.setFirstDeathDate(f.getKey()));

        dto.getCases().stream().skip(dto.getCases().size() - 1).findFirst().ifPresent(s -> comparison.setCurrentCasesAmount(s.getValue()));
        dto.getDeaths().stream().skip(dto.getDeaths().size() - 1).findFirst().ifPresent(s -> comparison.setCurrentDeathsAmount(s.getValue()));


        return comparison;
    }

}
