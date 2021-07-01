package ssst.healthdiary.backend.services;

import feign.Feign;

import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.clients.GoogleFitApiClient;

import javax.annotation.PostConstruct;

//@Service
//@EnableConfigurationProperties(GoogleProperties.class)
//@RequiredArgsConstructor
public class GoogleApiFeignService {

//    private final GoogleProperties googleProperties;
    private GoogleFitApiClient googleFitApiClient;

//    @PostConstruct
//    public void init(){
//        this.googleFitApiClient= Feign.builder()
//                .client(new OkHttpClient())
//                .encoder(new JacksonEncoder())
//                .decoder(new JacksonDecoder())
//                .target(GoogleFitApiClient.class, "https://accounts.google.com/o/oauth2/v2/auth");
//    }
//
//

}
