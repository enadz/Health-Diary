package ssst.healthdiary.backend.dtos.google;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class GoogleAuthorizationPayload {

  @NotEmpty
  private String code;
}
