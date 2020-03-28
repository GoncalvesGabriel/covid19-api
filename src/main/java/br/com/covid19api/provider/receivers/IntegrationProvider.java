package br.com.covid19api.provider.receivers;

import br.com.covid19api.dto.CovidHistoricalOutput;

public interface IntegrationProvider {

  CovidHistoricalOutput provideHistorical(String country);

}
