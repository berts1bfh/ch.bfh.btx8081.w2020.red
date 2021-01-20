package view.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import model.login.User;
import presenter.login.LoginPresenter;

/**
 * LoginView managing User to be logged in
 */
public class LoginView extends VerticalLayout {

    public LoginView() {
        User defaultUser = new User("Max", "Muster");
        LoginViewImpl view = new LoginViewImpl();
        new LoginPresenter(defaultUser, view);
        add(view);
    }

}
