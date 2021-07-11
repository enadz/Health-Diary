//package ssst.healthdiary.backend.clients;
//
//import feign.*;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import ssst.healthdiary.backend.dtos.UserStepResponsePayload;
//import ssst.healthdiary.backend.dtos.StepsRequest;
//import ssst.healthdiary.backend.entities.PatientSleepData;
//
//@FeignClient(name="google", url = "https://www.googleapis.com/fitness/v1/users/me")
//@Headers("Content-Type: application/json")
//public interface GoogleFitApiClient {
//
//    @GetMapping("/getData")
//    Object getData(@RequestHeader("Authorization") String authToken, @RequestBody Body queryBody);
//
////    @RequestLine("POST /v1/users/me/dataset:aggregate")
////    UserSleepResponsePayload getUserSleep(@QueryMap Map<String,String> queryMap);
//
//// https://www.googleapis.com/fitness/v1
//    /*@RequestLine("POST /users/me/dataset:aggregate")
//    @Headers({"Authorization: Bearer {accessToken}"})
//    UserStepResponsePayload getSteps(@Param("accessToken") String accessToken,
//                                     @QueryMap StepsRequest stepsRequest);*/
//
//    @RequestLine("Get /users/me/dataset:aggregate")
//    @Headers({"Authorization: Bearer {accessToken}"})
//    UserStepResponsePayload getSleep(@Param("accessToken") String accessToken,
//                                     @QueryMap PatientSleepData sleepRequest);
//
//
//}
