package ssst.healthdiary.backend.mappers;

import org.hl7.fhir.dstu3.model.HumanName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ssst.healthdiary.backend.dtos.HumanNamePayload;

@Mapper
public interface HumanNameMapper extends ResourceMapper<HumanNamePayload, HumanName> {

    @Mappings({
            @Mapping(target = "prefix", source = "prefix"),
            @Mapping(target = "family", source = "family"),
            @Mapping(target = "suffix", source = "suffix"),
            @Mapping(target = "given", source = "given")
    })
    HumanNamePayload toPayload(HumanName humanName);

    @Mappings({
            @Mapping(target = "prefix", source = "prefix"),
            @Mapping(target = "family", source = "family"),
            @Mapping(target = "suffix", source = "suffix"),
            @Mapping(target = "given", source = "given")
    })
    HumanName toEntity(HumanNamePayload namePayload);
}
