package controller;

import dao.UserDao;
import domain.User;
import exception.IncorrectDataUserInputException;
import exception.IncorrectPasswordException;
import exception.NoContainsUserException;
import view.LoginFrame;
import view.MainFrame;
import view.RegistrationFrame;

import java.util.Map;

public class LoginControllerImpl implements LoginController {
    private UserDao userDao;
    private MainFrame mainFrame;

    public LoginControllerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean login(String login, String password) throws NoContainsUserException, IncorrectPasswordException, IncorrectDataUserInputException {
        LoginFrame.getInstance().getLoginLabel().setText("Login:");
        LoginFrame.getInstance().getPasswordLabel().setText("Password:");
        if(checkInputData(login, password)){
            Map<String,User> users = userDao.findAll();
            if(users.containsKey(login)){
                if(password.equals(users.get(login).getPassword())){
                    mainFrame =  MainFrame.getInstance();
                    mainFrame.setCurUser(users.get(login));
                    LoginFrame.getInstance().clearFields();
                    return true;
                }else{
                    LoginFrame.getInstance().setRedTextPassword();
                    throw new IncorrectPasswordException("Password is not correct!");
                }
            }else{
                LoginFrame.getInstance().setRedTextLogin();
                throw new NoContainsUserException("This user is not registered.");
            }
        }

        return false;
    }

    private boolean checkInputData(String login, String password) throws IncorrectDataUserInputException {
        if(login == null || password == null ){
            throw new IncorrectDataUserInputException("Login or Password not enter!");
        }else if(login.toCharArray().length<=4) throw new IncorrectDataUserInputException("Login is short.");
        else if(password.toCharArray().length <=4) throw new IncorrectDataUserInputException("Password is short.");
        return true;
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
