package br.com.covid19api.provider.receivers;

import br.com.covid19api.config.rest.CoronaLmaoProperties;
import java.util.HashMap;
import java.util.Map;

import br.com.covid19api.dto.CovidHistoricalOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoronaLmaoConsumer implements IntegrationConsumer {

  @Autowired
  private RestTemplate template;

  @Autowired
  private CoronaLmaoProperties properties;

  @Override
  public void consume(String country) {
    Map<String, String> params = new HashMap<>();
    String urlFull = String.format("%s%s/%s", properties.getUrl(), properties.getHistoricalEndpoint(), country);
    CovidHistoricalOutput historical = template.getForObject(urlFull, CovidHistoricalOutput.class, params);
    System.out.println(historical);
  }
}
