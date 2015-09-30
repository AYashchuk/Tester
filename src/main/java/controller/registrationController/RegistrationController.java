package controller.registrationController;

public interface RegistrationController {

    boolean checkIin(String password, String firstName, String lastName, String login, String keyword, boolean isAdmin);
    void cancel();
}
