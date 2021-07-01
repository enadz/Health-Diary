//package ssst.healthdiary.backend.controllers;
//
//
//import feign.Param;
//import feign.QueryMap;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ssst.healthdiary.backend.clients.GoogleFitApiClient;
//import ssst.healthdiary.backend.dtos.AggregateBy;
//import ssst.healthdiary.backend.dtos.BucketByTime;
//import ssst.healthdiary.backend.dtos.UserStepResponsePayload;
//import ssst.healthdiary.backend.dtos.StepsRequest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class FeignGoogleApiController {
//
//    @Autowired
//    GoogleFitApiClient googleFitApiClient;
//
//    @GetMapping("/profile/sleep")
//    public UserStepResponsePayload returnSteps(@Param("accessToken") String accessToken,
//                                               @QueryMap StepsRequest stepsRequest){
//        AggregateBy aggregateBy=new AggregateBy("com.google.step_count.delta","derived:com.google.step_count.delta:com.google.android.gms:estimated_steps");
//        List<AggregateBy> aggregateByList= new ArrayList<AggregateBy>();
//        aggregateByList.add(aggregateBy);
//        BucketByTime bucket=new BucketByTime(86400000);
//
//        stepsRequest=new StepsRequest(aggregateByList, bucket, "1621460022000", "1621510022000");
//
//        return googleFitApiClient.getSteps(accessToken, stepsRequest);
//    }
//
//
//
//}
