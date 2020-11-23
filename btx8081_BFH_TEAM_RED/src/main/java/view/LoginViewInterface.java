package view;

import com.vaadin.flow.component.login.AbstractLogin;

/**
 * Login view interface for displaying logged in user
 */
public interface LoginViewInterface {

    boolean authenticate(AbstractLogin.LoginEvent event);

}
