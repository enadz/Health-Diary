package ssst.healthdiary.backend.mappers;

import java.util.Collection;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.mapstruct.factory.Mappers;
import ssst.healthdiary.backend.dtos.CodeableConceptPayload;

public interface CodeableConceptMapper {

  Collection<CodeableConceptPayload> toPayloads(Collection<CodeableConcept> source);

  Collection<CodeableConcept> toEntities(Collection<CodeableConceptPayload> source);

  CodeableConceptPayload toPayload(CodeableConcept source);

  CodeableConcept toEntity(CodeableConceptPayload source);

  CodeableConceptMapper INSTANCE = Mappers.getMapper(CodeableConceptMapper.class);
  
}
