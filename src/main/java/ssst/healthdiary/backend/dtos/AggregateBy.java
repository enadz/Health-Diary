package ssst.healthdiary.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AggregateBy  {

        private String dataTypeName;
        private String dataSourceId;

}