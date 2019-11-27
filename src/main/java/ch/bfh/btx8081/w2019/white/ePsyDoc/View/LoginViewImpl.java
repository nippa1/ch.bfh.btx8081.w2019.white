package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the login procedure.
 * I got inspired by this link: https://github.com/vaadin-learning-center/spring-secured-vaadin/blob/login-overlay-form/src/main/java/org/vaadin/paul/spring/ui/views/LoginView.java
 *
 * @author Sugeelan Selvasingham
 */

@Route(value = LoginViewImpl.ROUTE)
@PageTitle("Login")

public class LoginViewImpl extends VerticalLayout implements LoginView {
    public static final String ROUTE = "login";

    private VerticalLayout verticalLayout = new VerticalLayout();
    private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();
    private Button btnSubmit = new Button("Submit");


    private List<LoginViewListener> listeners = new ArrayList<>();


    private LoginOverlay login = new LoginOverlay();

    public LoginViewImpl() {
//        login.setAction("Homepage");
//        login.setOpened(true);
//        login.setTitle("ePsyDoc");
//        login.setDescription("Secure Authentication");
//        login.setForgotPasswordButtonVisible(false); // we won't implement this
//        getElement().appendChild(login.getElement());

        btnSubmit.addClickListener((x) -> {
            for (LoginViewListener listener : listeners) {
                listener.login(tfUsername.getValue(), tfPassword.getValue());
            }
        });

        verticalLayout.add(tfUsername, tfPassword, btnSubmit);
        this.add(verticalLayout);
    }


    @Override
    public String getTextFieldUsername() {
        return tfUsername.getValue();
    }

    @Override
    public String getTextFieldPassword() {
        return tfPassword.getValue();
    }

    @Override
    public boolean showLoginStatus() {
        return false;
    }

    @Override
    public void addListener(LoginViewListener listener) {
        listeners.add(listener);
    }

    public void letsGo() {
        this.addClickListener(e -> UI.getCurrent().navigate(AppointmentViewImpl.class));
    }

    public void problem(String message) {
        Notification.show("Der Computer sagt sein..." + message);
    }



}

