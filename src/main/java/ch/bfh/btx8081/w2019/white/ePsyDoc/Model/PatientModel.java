package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientModel {

	private int patientID;
	private String lastname;
	private String firstname;
	private String gender;
	private Date date;
	private String adress;
	private String zip;
	private List<PatientCase> patientCaseList = new ArrayList<PatientCase>();

	public PatientModel(int patientID, String lastname, String firstname, String gender, Date date, String adress,
			String zip) {

		this.patientID = patientID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender.toUpperCase();
		this.date = date;
		this.adress = adress;
		this.zip = zip;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZIP() {
		return zip;
	}

	public void setZIP(String zip) {
		this.zip = zip;
	}

	public void createPatientCase(int patientCaseID, int patientID) {
		PatientCase patientCase = new PatientCase(patientCaseID, patientID);
		patientCaseList.add(patientCase);
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}

	public PatientCase getSinglePatientCase(int patientCaseID) {
		PatientCase returnPatientCase = null;
		for (PatientCase patientCase : patientCaseList) {
			if (patientCase.getPatientcaseID() == patientCaseID) {
				returnPatientCase = patientCase;
			}
		}
		return returnPatientCase;
	}

}
