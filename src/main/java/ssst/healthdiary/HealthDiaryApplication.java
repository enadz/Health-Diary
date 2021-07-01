package ssst.healthdiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import ssst.healthdiary.backend.clients.HealthDiaryFeignClient;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
//@EnableFeignClients
public class HealthDiaryApplication {

   // @Autowired
  //  HealthDiaryFeignClient healthDiaryFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(HealthDiaryApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean ServletRegistrationBean(){
        ServletRegistrationBean registration=new ServletRegistrationBean(new SimpleRestfulServer(),"/fhir/*");
        registration.setName("FhirServlet");
        return registration;
    }
}
