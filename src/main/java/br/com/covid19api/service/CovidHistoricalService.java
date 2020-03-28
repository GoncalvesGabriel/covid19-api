package br.com.covid19api.service;

import br.com.covid19api.consumer.impl.ComparisonCovidHistoricalConsumer;
import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.dto.CovidHistoricalOutput;
import br.com.covid19api.provider.receivers.CoronaLmaoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidHistoricalService {

    @Autowired
    private CoronaLmaoProvider provider;

    @Autowired
    private ComparisonCovidHistoricalConsumer comparisonConsumer;

    public List<CovidHistoricalComparison> getComparison(List<String> countries) {
        List<CovidHistoricalComparison> results = new ArrayList<>();
        for (String country : countries) {
            CovidHistoricalOutput output = provider.provideHistorical(country);
            results.add(comparisonConsumer.consume(output));
        }
        return results;
    }

}
