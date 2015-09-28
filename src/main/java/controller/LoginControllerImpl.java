package controller;

import view.LoginFrame;
import view.RegistrationFrame;

public class LoginControllerImpl implements LoginController {
    @Override
    public boolean login() {
        return false;
    }

    @Override
    public void registration() {
        LoginFrame.getInstance().setVisible(false);
        LoginFrame.getInstance().clearFields();
        RegistrationFrame.getInstance().setVisible(true);
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
