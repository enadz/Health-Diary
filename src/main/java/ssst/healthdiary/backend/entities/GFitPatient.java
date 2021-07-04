package ssst.healthdiary.backend.entities;
import lombok.*;
import org.checkerframework.checker.units.qual.C;

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
    private int patientId;

    @OneToMany(cascade=CascadeType.ALL)
    private List<PatientSleepData> sleepDataList;

    @OneToMany(cascade=CascadeType.ALL)
    private List<PatientActivityData> activityDataList;

    @OneToMany(cascade=CascadeType.ALL)
    private List<PatientOxygenData> oxygenDataList;

    public GFitPatient(int patientId) {
        this.patientId = patientId;
    }
}
