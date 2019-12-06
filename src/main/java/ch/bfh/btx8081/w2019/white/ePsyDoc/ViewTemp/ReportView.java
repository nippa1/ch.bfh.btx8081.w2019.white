package ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp;

import java.util.ArrayList;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientCase;

public interface ReportView {

	interface ReportViewListener {
		// Report
		void clickNewPatientCase(int patientCaseID, int patientID);

		void clickDeletePatientCase();

		void deleteDiagnose(Diagnosis diagnosis);

		// Medication
		void clickAddMedication(Medication medication);

		void clickRemoveFromMedicationPlan(String brandname);
		
		void getPatientData();
		void getDoctorData();
		void getPatientCaseID();

	}

	void addListener(ReportViewListener listener);

	// Report
	void displayPatientCaseTabs(ArrayList<String> patientCaseIDs);

	void displayDoctorName(String firstname, String name);

	void displayPatientName(String firstname, String name);

	void displayPatientCaseID(String patientCaseID);


	// Medication
	void displayUpdateMedicationGrid(MedicationPlan medicationPlan);

	void displayUpdateDiagnosisGrid(ArrayList<Diagnosis> diagnosis);

	void displayPatientCase(PatientCase tempPatientCase);

}