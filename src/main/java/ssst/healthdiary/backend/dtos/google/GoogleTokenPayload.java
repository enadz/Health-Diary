package ssst.healthdiary.backend.dtos.google;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class GoogleTokenPayload {

  private String accessToken;

  private String refreshToken;
}
