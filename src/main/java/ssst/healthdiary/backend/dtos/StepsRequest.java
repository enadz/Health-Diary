package ssst.healthdiary.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ssst.healthdiary.backend.dtos.AggregateBy;
import ssst.healthdiary.backend.dtos.BucketByTime;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StepsRequest {
    private List<AggregateBy> aggregateBy;
    private BucketByTime bucketByTime;
    private String startTimeMillis;
    private String endTimeMillis;
}
