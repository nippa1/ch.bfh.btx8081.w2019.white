package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

public interface PatientView {
	interface PatientViewListener {		
		void clickGetPatientName(PatientModel patient);
		void clickGetPatientID(PatientModel patient);

	}

	void addListener(PatientViewListener listener);
	void displayPatientData(PatientModel patientModel);
	void displayPatientCaseData(PatientModel patientModel);
	
}
