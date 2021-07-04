package ssst.healthdiary.backend.entities;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "sleep_data")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientSleepData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "startTimeMillis")
    private String startTime;

    @Column(name = "endTimeMillis")
    private String endTime;

    @Column(name = "stage")
    private String stage;

    /*Date date=new Date(millis);*/



}
