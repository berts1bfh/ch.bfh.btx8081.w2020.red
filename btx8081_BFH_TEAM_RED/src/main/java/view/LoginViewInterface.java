package view;

import com.vaadin.flow.component.login.AbstractLogin;

/**
 * Login view interface for displaying logged in user
 */
public interface LoginViewInterface {

    /**
     * Authentication of user
     * @param event LoginEvent for authentication
     * @return boolean success of authentication attempt
     */
    boolean authenticate(AbstractLogin.LoginEvent event);

}
