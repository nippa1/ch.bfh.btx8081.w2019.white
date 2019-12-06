package ch.bfh.btx8081.w2019.white.ePsyDoc.PresenterTemp;

import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Diagnosis;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.DiagnosisList;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Medication;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.MedicationPlan;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.Report;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.ReportView;

public class ReportPresenter implements ReportView.ReportViewListener {
	private PatientModel model;
	private ReportView view;

	public ReportPresenter(PatientModel model, ReportView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void clickNewPatientCase(int patientCaseID, int patientID) {
		Patient tempPatient = model.getPatient((int) VaadinSession.getCurrent().getAttribute("patientID"));
		String tempPatientID = String.valueOf(tempPatient.getPatientID());
		String tempPatientCaseID = tempPatientID + "." + String.valueOf(tempPatient.getPatientCaseList().size());
		model.getPatient(Integer.parseInt(tempPatientID)).addPatientCase(tempPatientCaseID);
	}

	@Override
	public void clickDeletePatientCase() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		tempPatient.removePatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void clickAddMedication(Medication medication) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		MedicationPlan medicationPlan = tempPatientCase.getMedicationPlan();
		view.displayPatientCase(tempPatientCase);
		medicationPlan.addToMedicationPlan(medication);
		view.displayUpdateMedicationGrid(medicationPlan);
	}

	@Override
	public void clickRemoveFromMedicationPlan(String brandname) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
	}

	@Override
	public void deleteDiagnose(Diagnosis diagnosis) {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		PatientCase tempPatientCase = tempPatient.getPatientCase(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID")));
		Report report = tempPatientCase.getReport();
		DiagnosisList diagnosisList = report.getDiagnosisList();
		diagnosisList.RemoveFromDiagnosisList(diagnosis);
	}

	@Override
	public void getPatientData() {
		Patient tempPatient = model.getPatient(Integer.parseInt((String) VaadinSession.getCurrent().getAttribute("patientID")));
		view.displayPatientName(tempPatient.getFirstname(), tempPatient.getLastname());

	}

	@Override
	public void getDoctorData() {
		view.displayDoctorName((String) VaadinSession.getCurrent().getAttribute("doctorFirstname"),
				(String) VaadinSession.getCurrent().getAttribute("doctorName"));

	}

	@Override
	public void getPatientCaseID() {
		view.displayPatientCaseID((String) VaadinSession.getCurrent().getAttribute("patientCaseID"));
		
	}

}
