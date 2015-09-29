package controller;

import dao.UserDao;
import domain.User;
import exception.IncorrectDataUserInputException;
import view.LoginFrame;
import view.MainFrame;
import view.RegistrationFrame;

public class RegistrationControllerImpl implements RegistrationController {
    UserDao userDao;

    public RegistrationControllerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkIin(String password, String firstName, String lastName, String login, String keyword, boolean isAdmin) {
        try {
            if(isAdmin){
                checkCorrectData(password, firstName, lastName, login, keyword);
                registration(password, firstName, lastName, login,keyword);
            }else {
                checkCorrectData(password, firstName, lastName, login, null);
                registration(password, firstName, lastName, login, null);
            }

        } catch (IncorrectDataUserInputException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public void cancel() {
        RegistrationFrame.getInstance().setVisible(false);
        LoginFrame.getInstance().setVisible(true);
    }



    private void checkCorrectData(String pass,String firstName,String lastName,String login,String keyword) throws IncorrectDataUserInputException {
        if(pass.toCharArray().length == 0){
            RegistrationFrame.getInstance().setState("field password is empty");
            throw new IncorrectDataUserInputException("field password is empty");
        }
        if(firstName.toCharArray().length == 0){
            RegistrationFrame.getInstance().setState("field first name is empty");
            throw new IncorrectDataUserInputException("field first name is empty");
        }
        if(lastName.toCharArray().length == 0){
            RegistrationFrame.getInstance().setState("field last name is empty");
            throw new IncorrectDataUserInputException("field surname is empty");
        }
        if(login.toCharArray().length == 0){
            RegistrationFrame.getInstance().setState("field login is empty");
            throw new IncorrectDataUserInputException("field login is empty");
        }
        if(pass.toCharArray().length <=4){
            RegistrationFrame.getInstance().setState("password is short");
            throw new IncorrectDataUserInputException("password is short");
        }if(login.toCharArray().length <=4){
            RegistrationFrame.getInstance().setState("login is short");
            throw new IncorrectDataUserInputException("login is short");
        }if(keyword != null){
            if(!keyword.equals("admin")){
                RegistrationFrame.getInstance().setState("keyword incorrect");
                throw new IncorrectDataUserInputException("keyword incorrect");
            }
        }

    }

    public void registration(String pass,String firstName,String lastName,String login, String keyword){
        User user;
        if(keyword != null) user = new User(firstName,lastName,login,pass,true);
        else  user = new User(firstName,lastName,login,pass);
        if(userDao.create(user)!= null){
            MainFrame mainFrame =  MainFrame.getInstance();
            mainFrame.setCurUser(user);
        }
        RegistrationFrame.getInstance().setVisible(false);
        RegistrationFrame.getInstance().clearFields();

    }
}
