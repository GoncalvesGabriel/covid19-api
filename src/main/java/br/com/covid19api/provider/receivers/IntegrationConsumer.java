package br.com.covid19api.provider.receivers;

public interface IntegrationConsumer {

  void consume(String country);

}
