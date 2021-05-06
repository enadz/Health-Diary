package ssst.healthdiary.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "google_tokens")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoogleTokenEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "access_token")
  private String accessToken;

  @Column(name = "refresh_token")
  private String refreshToken;
}
