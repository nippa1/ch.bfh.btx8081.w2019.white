package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientView;

import java.util.List;

public class PatientPresenter implements PatientView.PatientViewListener {
    private PatientModel model;
    private PatientView view;

    public PatientPresenter(PatientModel model, PatientView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
//        onLoadPatientList();
    }




    @Override
    public void clickGetPatientName(PatientModel patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clickGetPatientID(PatientModel patient) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLoadPatientList() {
        System.out.println("#set PatientList");
        view.setPatientList(model.getPatientList());
    }



}
