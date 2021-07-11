package ssst.healthdiary.backend.controllers;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.fitness.Fitness;
import com.google.api.services.fitness.FitnessScopes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
//import ssst.healthdiary.backend.clients.HealthDiaryFeignClient;
import ssst.healthdiary.backend.services.GoogleTokenService;
import ssst.healthdiary.backend.services.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api"})
public class GoogleAuth2ControllerTest {

//    private static HttpTransport httpTransport;
//    private static JsonFactory jsonFactory;
//    private static HttpRequestInitializer httpRequestInitializer;
  @Autowired
    GoogleTokenService googleTokenService;

    @PostMapping("/userToken")
    public String recievingAuthToken(@RequestBody String authToken) {
        return authToken;
    }

//    @GetMapping("/id")
//    public String index() {
//        OAuth2User user = getCurrentUser();
//        Object credentials =getcredentials();


//        Fitness service = new Fitness.Builder(
//                httpTransport,
//                jsonFactory,
//                httpRequestInitializer)
//                .build();
//
//        public Fitness.Users.Dataset.Aggregate aggregate(java.lang.String user.getAttributes().get("sub"),
//                AggregateRequest content)
//                                          throws java.io.IOException
//
//        return "Hello " + user.getAttributes().get("name") + ". Your email is " + user.getAttributes().get("email")
//                + " and your profile picture is <img src='"+user.getAttributes().get("picture")+"' /> <br />"
//                + " \n Here is your data "+user.getAttributes()+" and your authorities are "+ user.getAuthorities()+"' /> <br />"
//                + "<a href='/logout'>logout</a>" + "Credentials thingy be like "+ credentials+ "\n" ;
//    }

//    @PostMapping("/https://www.googleapis.com/fitness/v1/users/me/dataset:aggregate")
//    public void getSteps(@RequestBody getSteps)
//    {
//        OAuth2User user = getCurrentUser();
//        String start="2021-05-05T00:00.000Z";
//        String end="2021-05-17T23:59:59.999Z";
//
//    }

//    public OAuth2User getCurrentUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return ((OAuth2AuthenticationToken)auth).getPrincipal();
//    }
//
//    public Object getcredentials() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return ((OAuth2AuthenticationToken)auth);
//    }
//

//    @GetMapping("/not-restricted")
//    public String notRestricted() {
//        return "you don't need to be logged in";
//    }
//
//    @GetMapping("/restricted")
//    public String restricted() {
//        return "if you see this you are logged in";
//    }
//
//    @GetMapping("/user")
//    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//       return Collections.singletonMap("name", principal.getAttribute("name"));
//    }

//    @GetMapping("/userToken")
//    public String userToken(String token) {
//        return token;
//    }

}