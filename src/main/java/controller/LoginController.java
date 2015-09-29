package controller;

import exception.IncorrectDataUserInputException;
import exception.IncorrectPasswordException;
import exception.NoContainsUserException;

public interface LoginController {
    boolean login(String login, String password) throws NoContainsUserException, IncorrectPasswordException, IncorrectDataUserInputException;
    void registration();
    void exit();
}
