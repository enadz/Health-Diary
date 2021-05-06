

package ssst.healthdiary.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ssst.healthdiary.backend.dtos.google.GoogleTokenPayload;
import ssst.healthdiary.backend.entities.GoogleTokenEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GoogleTokenResponseMapper extends
    ResourceMapper<GoogleTokenPayload, GoogleTokenEntity> {

  GoogleTokenResponseMapper INSTANCE = Mappers.getMapper(GoogleTokenResponseMapper.class);
}
