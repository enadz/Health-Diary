package ssst.healthdiary.backend.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.okhttp.client.OkHttpRestfulClientFactory;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.IRestfulClientFactory;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ssst.healthdiary.backend.properties.ServiceProperties;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
@AllArgsConstructor
public class HapiClientConfiguration {

  private ServiceProperties serviceProperties;

  @Bean
  public FhirContext fhirContext() {
    return new FhirContext(FhirVersionEnum.DSTU3);
  }

  @Bean
  public IRestfulClientFactory fhirRestfulClientFactory() {
    return new OkHttpRestfulClientFactory(fhirContext());
  }

  @Bean
  public IGenericClient fhirClient(final IRestfulClientFactory clientFactory) {
    return clientFactory.newGenericClient(serviceProperties.getFhir().getUrl());
  }

  /**
   * Bean for customize Jackson mapper. This bean add custom serializer for all HAPI objects and
   * provide the serialization control to HAPI Json builder.
   *
   * @return Customized mapper.
   */
//  @Bean
//  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//    return jacksonObjectMapperBuilder -> {
//      jacksonObjectMapperBuilder
//          .serializerByType(IBaseResource.class,
//              new HapiObjectSerializer(IBaseResource.class, fhirContext()));
//    };
//  }
}