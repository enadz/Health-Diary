package ssst.healthdiary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "patient")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Patient {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer identifier;
    private boolean active;
    private String firstName;
    private String lastName;
    private Date dob;
    private boolean deceased;
    //private MaritalStatus maritalStatus;
    private String address;
    private String phonenumber;
    private String email;
    //private Gender gender;
    //private MultipleBirth multipleBirth;
    //private Language language;

    public Patient(boolean active, String firstName, String lastName, Date dob, boolean deceased, String address, String phonenumber, String email) {
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.deceased = deceased;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        //this.gender = gender;
    }
}


//Add photo, generalPractitioner, managingOrganization attributes later trustedContact
