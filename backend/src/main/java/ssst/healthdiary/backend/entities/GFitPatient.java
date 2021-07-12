package ssst.healthdiary.backend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gfitpatient")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GFitPatient {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    //public GFitPatient(int patientId) {this.patientId = patientId;}

}
