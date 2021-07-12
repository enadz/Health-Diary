package ssst.healthdiary.backend.mappers;

import org.hl7.fhir.dstu3.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ssst.healthdiary.backend.dtos.AddressPayload;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends ResourceMapper<AddressPayload, Address> {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(source = "line", target = "line"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "country", target = "country"),
    })
    AddressPayload toPayload(Address address);

    @Mappings({
            @Mapping(source = "line", target = "line"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "country", target = "country"),
    })
    Address toEntity(AddressPayload addressPayload);
}
