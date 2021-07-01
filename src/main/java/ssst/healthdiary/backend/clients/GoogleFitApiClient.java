package ssst.healthdiary.backend.clients;

import feign.*;
import ssst.healthdiary.backend.dtos.UserStepResponsePayload;
import ssst.healthdiary.backend.dtos.StepsRequest;

//@FeignClient(name="google", url = "https://www.googleapis.com/fitness/v1/users/me")
//@Headers("Content-Type: application/json")
public interface GoogleFitApiClient {

//    @GetMapping("/getData")
//    Object getData(@RequestHeader("Authorization") String someToken, @RequestBody Body queryBody);

//    @RequestLine("POST /v1/users/me/dataset:aggregate")
//    UserSleepResponsePayload getUserSleep(@QueryMap Map<String,String> queryMap);

// https://www.googleapis.com/fitness/v1
    /*@RequestLine("POST /users/me/dataset:aggregate")
    @Headers({"Authorization: Bearer {accessToken}"})
    UserStepResponsePayload getSteps(@Param("accessToken") String accessToken,
                                     @QueryMap StepsRequest stepsRequest);*/
//
//    @RequestLine("Get /users/me/dataset:aggregate")
//    @Headers({"Authorization: Bearer {accessToken}"})
//    UserStepResponsePayload getSleep(@Param("accessToken") String accessToken,
//                                     @QueryMap SleepRequest sleepRequest);


}
