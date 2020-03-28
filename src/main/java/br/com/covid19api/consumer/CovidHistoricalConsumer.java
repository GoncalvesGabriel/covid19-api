package br.com.covid19api.consumer;

import br.com.covid19api.dto.CovidHistoricalOutput;

public interface CovidHistoricalConsumer<T> {

    T consume(CovidHistoricalOutput dto);

}
