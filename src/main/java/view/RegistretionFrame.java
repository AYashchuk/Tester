package view;


import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import exception.IncorectDataUserInputException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistretionFrame extends JFrame {
    private UserDao userDao = new UserDaoImpl();
    private static RegistretionFrame registretionFrame;
    private JPasswordField passwordField;
    private JButton ok;
    private JButton cancel;
    private JTextField firstNameField;
    private JTextField loginField;
    private JTextField secondNameField;
    private JLabel state;
    private CurrentActionListener actionListener = new CurrentActionListener();

    private RegistretionFrame() throws HeadlessException {
        super("Registration in Tester");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(setContent());
        pack();
    }

    private Box setContent(){
        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box2 = Box.createHorizontalBox();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(15);
        box2.add(firstNameLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(firstNameField);

        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box3 = Box.createHorizontalBox();
        JLabel secondNameLabel = new JLabel("Second Name:");
        secondNameField = new JTextField(15);
        box3.add(secondNameLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(secondNameField);


        // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box4 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        box4.add(passwordLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(passwordField);


        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box5 = Box.createHorizontalBox();
        ok = new JButton("OK");
        ok.addActionListener(actionListener);
        cancel = new JButton("Cancel");
        cancel.addActionListener(actionListener);
        box5.add(Box.createHorizontalGlue());
        box5.add(ok);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(cancel);

        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box6 = Box.createHorizontalBox();
        state = new JLabel("State:");
        box6.add(Box.createHorizontalStrut(6));
        box6.add(state);

        // Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box6);
        return mainBox;
    }


    public static RegistretionFrame getInstance(){
        if(registretionFrame == null){
            registretionFrame = new RegistretionFrame();
            return registretionFrame;
        }else
            return registretionFrame;
    }


    class CurrentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JButton) e.getSource()) == ok) {
                System.out.println("ok");
                String pass = new String (passwordField.getPassword()).trim();
                String firstName = firstNameField.getText().trim();
                String lastName = secondNameField.getText().trim();
                String login = loginField.getText().trim();
                try {
                    checkCorectData(pass, firstName, lastName, login);
                    registion(pass, firstName, lastName, login);
                } catch (IncorectDataUserInputException e1) {
                    e1.printStackTrace();
                }
            }
            if (((JButton) e.getSource()) == cancel) {
                getInstance().setVisible(false);
                LoginFrame.getInstance().setVisible(true);
            }
        }
    }

    private void checkCorectData(String pass,String firstName,String lastName,String login) throws IncorectDataUserInputException {
        if(pass.toCharArray().length == 0){
            state.setText("State: field password is empty");
            throw new IncorectDataUserInputException("State: field password is empty");
        }
        if(firstName.toCharArray().length == 0){
            state.setText("State: field first name is empty");
            throw new IncorectDataUserInputException("State: field password is empty");
        }
        if(lastName.toCharArray().length == 0){
            state.setText("State: field last name is empty");
            throw new IncorectDataUserInputException("State: field password is empty");
        }
        if(login.toCharArray().length == 0){
            state.setText("State: field login is empty");
            throw new IncorectDataUserInputException("State: field password is empty");
        }
        if(pass.toCharArray().length <=4){
            state.setText("State: password is short");
            throw new IncorectDataUserInputException("State: password is short");
        }if(login.toCharArray().length <=4){
            state.setText("State: login is short");
            throw new IncorectDataUserInputException("State: login is short");
        }

    }

    public void registion(String pass,String firstName,String lastName,String login){
            User user = new User(firstName,lastName,login,pass);
            userDao.create(user);
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getSecondNameField() {
        return secondNameField;
    }
}
