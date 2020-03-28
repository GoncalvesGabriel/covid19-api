package br.com.covid19api.provider.receivers;

import br.com.covid19api.config.rest.CoronaLmaoProperties;
import br.com.covid19api.dto.CovidHistoricalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class CoronaLmaoProvider implements IntegrationProvider {

  @Autowired
  private RestTemplate template;

  @Autowired
  private CoronaLmaoProperties properties;

  @Override
  public CovidHistoricalOutput provideHistorical(String country) {
    Map<String, String> params = new HashMap<>();
    String urlFull = String.format("%s%s/%s", properties.getUrl(), properties.getHistoricalEndpoint(), country);
    return template.getForObject(urlFull, CovidHistoricalOutput.class, params);
  }
}
