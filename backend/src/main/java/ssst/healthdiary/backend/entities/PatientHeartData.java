package ssst.healthdiary.backend.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "heartrate_data")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientHeartData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private GFitPatient gfitpatient;

    @Column(name = "startTimeMillis")
    private String startTime;

    @Column(name = "endTimeMillis")
    private String endTime;

    @Column(name = "bpm")
    private float bpm;

    /*Date date=new Date(millis);*/

}
