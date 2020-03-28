package br.com.covid19api.consumer.impl;

import br.com.covid19api.consumer.CovidHistoricalConsumer;
import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.dto.CovidHistoricalOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

@Component
public class ComparisonCovidHistoricalConsumer implements CovidHistoricalConsumer<CovidHistoricalComparison> {

    @Override
    public CovidHistoricalComparison consume(CovidHistoricalOutput dto) {
        CovidHistoricalComparison comparison = new CovidHistoricalComparison();

        Optional<Entry<String, Integer>> firstCase = dto.getCases().stream().filter(e -> e.getValue() > 0).findFirst();
        Optional<Entry<String, Integer>> firstDeath = dto.getDeaths().stream().filter(e -> e.getValue() > 0).findFirst();

        comparison.setCountry(dto.getCountry());
        firstCase.ifPresent(f -> comparison.setFirstCaseDate(f.getKey()));
        firstDeath.ifPresent(f -> comparison.setFirstDeathDate(f.getKey()));

        dto.getCases().stream().skip(dto.getCases().size() - 1).findFirst().ifPresent(s -> comparison.setCurrentCasesAmount(s.getValue()));
        dto.getDeaths().stream().skip(dto.getDeaths().size() - 1).findFirst().ifPresent(s -> comparison.setCurrentDeathsAmount(s.getValue()));

        comparison.setMostCasesDate(getLargestAmountDate(new ArrayList<>(dto.getCases())));
        comparison.setMostDeathsDate(getLargestAmountDate(new ArrayList<>(dto.getDeaths())));

        return comparison;
    }

    private String getLargestAmountDate(List<Entry<String, Integer>> entriesList) {
        Optional<CovidComparingVO> max = IntStream.range(1, entriesList.size()).mapToObj(i -> new CovidComparingVO(
                entriesList.get(i - 1).getValue(), entriesList.get(i).getValue(), entriesList.get(i).getKey()))
                .max(Comparator.comparing(CovidComparingVO::getAmountDiff));

        if (max.isPresent()) {
            return String.format("%s - %s", max.get().getCurrentDate(), max.get().getAmountDiff());
        }
        return "";
    }

    @Data
    @AllArgsConstructor
    private static class CovidComparingVO {

        private Integer previousAmount;

        private Integer currentAmount;

        private String currentDate;

        public Integer getAmountDiff() {
            return this.currentAmount - this.previousAmount;
        }
    }

}
