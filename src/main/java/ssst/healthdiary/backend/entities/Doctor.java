package ssst.healthdiary.backend.entities;
import lombok.*;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String doctorId;

    @Column(name="full_name")
    private String name;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @ManyToMany
    private List<GFitPatient> patients;
}
