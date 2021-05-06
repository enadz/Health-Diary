//package ssst.healthdiary.backend.config;
//
//import ssst.healthdiary.backend.properties.SwaggerProperties;
//import java.util.List;
//import java.util.Set;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//@AllArgsConstructor
//@EnableConfigurationProperties(SwaggerProperties.class)
//public class SwaggerConfig {
//
//  private static final String API_KEY = "apiKey";
//  private static final String HEADER = "header";
//
//  private SwaggerProperties swaggerProperties;
//
//  @Bean
//  public Docket swaggerPlugin() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("ssst.healthdiary.backend"))
////        .paths(Predicates.not(PathSelectors.regex("/error")))
//        .build()
//        .produces(Set.of(MediaType.APPLICATION_JSON_VALUE))
//        .protocols(swaggerProperties.getProtocols())
//        .apiInfo(apiInfo())
//        .securitySchemes(List.of(apiKey()))
//        .securityContexts(List.of(securityContext()));
//  }
//
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//        .title(swaggerProperties.getTitle())
//        .description(swaggerProperties.getDescription())
//        .version(swaggerProperties.getVersion())
//        .license(swaggerProperties.getLicense())
//        .licenseUrl(swaggerProperties.getLicenseUrl())
//        .build();
//  }
//
//  private ApiKey apiKey() {
//    return new ApiKey(API_KEY, HttpHeaders.AUTHORIZATION, HEADER);
//  }
//
//  private SecurityContext securityContext() {
//    return SecurityContext.builder()
//        .securityReferences(List.of(SecurityReference.builder()
//            .scopes(new AuthorizationScope[0])
//            .reference(API_KEY)
//            .build()))
////        .forPaths(PathSelectors.any())
//        .build();
//  }
//}
