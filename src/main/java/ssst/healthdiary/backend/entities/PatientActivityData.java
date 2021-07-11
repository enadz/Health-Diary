package ssst.healthdiary.backend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "step_data")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientActivityData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private GFitPatient gfitpatient;

    @Column(name = "startTimeMillis")
    private String startTime;

    @Column(name = "endTimeMillis")
    private String endTime;

    @Column(name = "steps")
    private int steps;

    /*Date date=new Date(millis);*/



}