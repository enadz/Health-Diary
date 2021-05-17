package ssst.healthdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // (exclude = {SecurityAutoConfiguration.class})
@EnableFeignClients
public class HealthDiaryApplication {

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
