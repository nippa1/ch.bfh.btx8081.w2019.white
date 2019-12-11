package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.Doctor;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    int appointmentID;

    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToOne(mappedBy = "appointment")
    private PatientCase patientCase;

    Date appointmentDate;

//	todo: auskommentiert, lg sugi
//	PatientModel patient;
//	DateTime date;


    public Appointment() {

    }


// todo: 10.12.2019 - lg sugi
//	public Appointment(PatientModel patient, DateTime date) {
//		this.patient = patient;
//		this.date = date;
//	}

}
