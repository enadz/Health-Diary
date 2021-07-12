package ssst.healthdiary.backend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.codesystems.AdministrativeGender;
import org.hl7.fhir.dstu3.model.codesystems.V3MaritalStatus;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class PatientPayload {
    @ApiModelProperty(name = "id", dataType = "string")
    @Id
    private String id;

    @ApiModelProperty(value = "name", dataType = "object")
    private List<HumanNamePayload> name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "birthDate", dataType = "date")
    private Date birthDate;

    @ApiModelProperty(value = "gender", dataType = "string", allowableValues = "MALE,FEMALE,OTHER,UNKNOWN")
    private AdministrativeGender gender;

    @ApiModelProperty(value = "list of addresses")
    private List<AddressPayload> address;

//    private List<ContactPointPayload> contactPointPayload;

    private boolean active;

}
