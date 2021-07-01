package ssst.healthdiary.backend.clients;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import ssst.healthdiary.backend.dtos.UserStepResponsePayload;

import java.util.List;
import java.util.Map;

import java.util.Map;

@FeignClient(url = "https://www.googleapis.com/fitness/v1/users/me",name="GOOGLE-API")
public interface HealthDiaryFeignClient {

    // https://www.googleapis.com/fitness/v1/users/me

    @RequestLine("POST /dataset:aggregate")
    @Headers({"Authorization: Bearer {accessToken}"})
    UserStepResponsePayload getStepData(@Param("userId") String userId,
                                        @Param("accessToken") String accessToken,
                                        @QueryMap Map<String, String> queryMap,
                                        @Param("durationMillis") int durationMillis,
                                        @Param("endTimeMillis") int endTimeMillis,
                                        @Param("startTimeMillis") int startTimeMillis);

//  "aggregateBy": [{
//        "dataTypeName": "com.google.step_count.delta",
//        "dataSourceId": "derived:com.google.step_count.delta:com.google.android.gms:estimated_steps"
//    }],
//  "bucketByTime": { "durationMillis": 86400000 },
//  "endTimeMillis": 1575609060000,
//  "startTimeMillis": 1575591360000
//}


//    @RequestLine("POST /dataset:aggregate")
//    @Headers({"Authorization: Bearer {accessToken}"})
//    UserSleepResponsePayload getSleepData(@Param("userId") String userId,
//                                         @Param("accessToken") String accessToken,
//                                         @QueryMap Map<String, String> queryMap,
//                                         @Param("endTimeMillis") int endTimeMillis,
//                                         @Param("startTimeMillis") int startTimeMillis);
//

//{
//  "aggregateBy": [
//    {
//      "dataTypeName": "com.google.sleep.segment"
//    }
//  ],
//  "endTimeMillis": 1575609060000,
//  "startTimeMillis": 1575591360000
//}

}