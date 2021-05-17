package ssst.healthdiary.backend.clients;


import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Map;

@FeignClient
public interface HealthDiaryFeignClient {

    // https://www.googleapis.com/fitness/v1
//    @RequestLine("POST /users/{userId}/dataset:aggregate")
//    @Headers({"Authorization: Bearer {accessToken}"})
//    UsersListResponsePayload getSleepData(@Param("userId") String userId,
//                                          @Param("accessToken") String accessToken,
//                                          @QueryMap Map<String, String> queryMap,
//                                          @Param("endTimeMillis") int endTimeMillis,
//                                          @Param("startTimeMillis") int startTimeMillis);
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