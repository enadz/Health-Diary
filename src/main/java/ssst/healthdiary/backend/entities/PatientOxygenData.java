package ssst.healthdiary.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "oxygen_saturation_data")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientOxygenData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private GFitPatient gfitpatient;

    @Column(name = "startTimeMillis")
    private String startTime;

    @Column(name = "endTimeMillis")
    private String endTime;

    @Column(name = "oxygen_saturation")
    private  float oxygenSaturation;

    /*Date date=new Date(millis);*/

}
