package br.com.covid19api.config.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "corona.lmao")
public class CoronaLmaoProperties {

  private String url;

  private String historicalEndpoint;

}
