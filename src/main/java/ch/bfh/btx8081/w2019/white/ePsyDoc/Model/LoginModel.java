package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sugeelan Selvasingham
 */

public class LoginModel {
    List<Doctor> dataBaseDoctors = new ArrayList<>();

    private String username;
    private String password;
    private Doctor selectedDoctor;

    public boolean getLoginsuccess() {
        return loginsuccess;
    }

    private boolean loginsuccess = false;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int findDoctorInDataBase(String username) {

        for (int i = 0; i < dataBaseDoctors.size(); i++) {
            if (dataBaseDoctors.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1; //TODO: Exception necessary
    }

    public Doctor getDoctor(String username, String password) {

        int arrIndex = findDoctorInDataBase(username);

        if (arrIndex != -1) {
            if (checkCredential(arrIndex, password)) {
                loginsuccess = true;
                return dataBaseDoctors.get(findDoctorInDataBase(username));
            }
        }
        return null; //todo: exception handling
    }

    public boolean checkCredential(int arrIndex, String password) {
        return (dataBaseDoctors.get(arrIndex).getPassword().equals(password));
    }

    public void search() {
        selectedDoctor = getDoctor(username, password);
    }

    public void init() {
        //String firstname, String name, String username, String password
        dataBaseDoctors.add(new Doctor("Sugeelan", "Selva", "selvs1", "gibbiX12345"));
        dataBaseDoctors.add(new Doctor("Janahan", "Sellathurai", "sellj1", "Sommer50"));
    }


}
