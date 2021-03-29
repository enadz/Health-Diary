package ssst.healthdiary.backend.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private Fhir fhir = new Fhir();
    private GoogleApi googleApi = new GoogleApi();

    @Getter
    @Setter
    public static class Fhir {

        private String url = "";
    }

    @Getter
    @Setter
    public static class GoogleApi {

        private String clientId = "";
        private String clientSecret = "";
        private String spreadsheetId = "";
    }
}
