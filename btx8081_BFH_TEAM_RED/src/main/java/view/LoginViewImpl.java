package view;

import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * LoginView implementation for login form
 * TODO: Implement in main-view overlay (?)
 */
public class LoginViewImpl extends VerticalLayout implements LoginViewInterface {

    public LoginViewImpl() {
        LoginForm component = new LoginForm();
        component.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e);
            if (isAuthenticated) {

                // To MainView
            } else {
                component.setError(true);
            }
        });
    }

    /**
     * Authenticates user login
     *
     * @param event LoginEvent
     * @return boolean
     */
    @Override
    public boolean authenticate(AbstractLogin.LoginEvent event) {
        return false; // TODO: Implement Authentication
    }
}
