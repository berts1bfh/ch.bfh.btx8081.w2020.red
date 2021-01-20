package presenter;

import model.User;
import view.LoginViewImpl;

/**
 * Loads user and handles login
 */
public class LoginPresenter {

    private final User user;
    private final LoginViewImpl view;

    public LoginPresenter(User user, LoginViewImpl view) {
        this.user = user;
        this.view = view;
    }

    /**
     * Handles login request from user
     *
     * @param login    String username for login
     * @param password String password for login
     */
    public void sendLoginRequest(String login, String password) {
        // TODO: Check with DB for existing username & password match
        // Load corresponding user model then update main view accordingly
        // MainView should implement setUsername() to update username displayed
        // view.displayUsername("Default");
    }

}
