
package ssst.healthdiary.backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ssst.healthdiary.backend.entities.GoogleTokenEntity;

public interface GoogleTokenRepository extends JpaRepository<GoogleTokenEntity, Long> {

  Optional<GoogleTokenEntity> findByUserId(String userId);
}
