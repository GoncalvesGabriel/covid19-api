package br.com.covid19api.consumer.impl;

import br.com.covid19api.consumer.CovidHistoricalConsumer;
import br.com.covid19api.dto.CovidHistoricalComparison;
import br.com.covid19api.dto.CovidHistoricalOutput;

public class ComparisonCovidHistoricalConsumer implements CovidHistoricalConsumer<CovidHistoricalComparison> {

    @Override
    public CovidHistoricalComparison consume(CovidHistoricalOutput dto) {
        return null;
    }

}
