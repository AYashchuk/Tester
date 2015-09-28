package view;


import controller.RegistrationController;
import controller.RegistrationControllerImpl;
import dao.UserDaoImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFrame extends JFrame {
    private RegistrationController registrationController;
    private static RegistrationFrame registretionFrame;
    private JPasswordField passwordField;
    private JButton ok;
    private JButton cancel;
    private JTextField firstNameField;
    private JTextField loginField;
    private JTextField secondNameField;
    private JTextField keyWordField;
    private JCheckBox isAdmin;
    private JLabel state;
    private CurrentActionListener actionListener = new CurrentActionListener();
    private JLabel keyWordLabel;
    private MainFrame mainFrame;

    private RegistrationFrame(RegistrationController registrationController) throws HeadlessException {
        super("Registration in Tester");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        getContentPane().add(setContent(), BorderLayout.NORTH);
        getContentPane().add(state, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        this.registrationController = registrationController;
    }

    private Box setContent(){
        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(loginField);

        // Настраиваем Вторую горизонтальную панель
        Box box2 = Box.createHorizontalBox();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(15);
        box2.add(firstNameLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(firstNameField);

        // Настраиваем третью горизонтальную панель (для ввода логина)
        Box box3 = Box.createHorizontalBox();
        JLabel secondNameLabel = new JLabel("Surname:");
        secondNameField = new JTextField(15);
        box3.add(secondNameLabel);
        box3.add(Box.createHorizontalStrut(14));
        box3.add(secondNameField);


        // Настраиваем четвертую горизонтальную панель (для ввода пароля)
        Box box4 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        box4.add(passwordLabel);
        box4.add(Box.createHorizontalStrut(8));
        box4.add(passwordField);



        Box box5 = Box.createHorizontalBox();
        isAdmin = new JCheckBox("Are you Admin?");
        isAdmin.addActionListener(actionListener);
        box5.add(Box.createHorizontalGlue());
        box5.add(isAdmin);

        // Настраиваем четвертую горизонтальную панель (для ввода пароля)
        Box box6 = Box.createHorizontalBox();
        keyWordLabel = new JLabel("Keyword:");
        keyWordField = new JPasswordField(15);
        keyWordLabel.setVisible(false);
        keyWordField.setVisible(false);
        box6.add(keyWordLabel);
        box6.add(Box.createHorizontalStrut(8));
        box6.add(keyWordField);

        // Настраиваем пятую горизонтальную панель (с кнопками)
        Box box7 = Box.createHorizontalBox();
        ok = new JButton("OK");
        ok.addActionListener(actionListener);
        cancel = new JButton("Cancel");
        cancel.addActionListener(actionListener);
        box7.add(Box.createHorizontalGlue());
        box7.add(ok);
        box7.add(Box.createHorizontalStrut(6));
        box7.add(cancel);


        // Настраиваем третью горизонтальную панель (с кнопками)
/*      Box box6 = Box.createHorizontalBox();*/
        state = new JLabel(){
            @Override
            public void setText(String text){
                super.setText("State: " + text);
            }
        };

        state.setHorizontalAlignment(SwingConstants.LEFT);
        state.setPreferredSize(new Dimension(100, 16));
//        box6.add(Box.createHorizontalStrut(6));
//        box6.add(state);

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
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box7);
        mainBox.add(Box.createVerticalStrut(12));

        return mainBox;
    }


    public static RegistrationFrame getInstance(){
        if(registretionFrame == null){
            registretionFrame = new RegistrationFrame(new RegistrationControllerImpl(new UserDaoImpl()));
            return registretionFrame;
        }else
            return registretionFrame;
    }


    class CurrentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() == isAdmin){
                if(isAdmin.isSelected()){
                    keyWordField.setVisible(true);
                    keyWordLabel.setVisible(true);
                }else{
                    keyWordField.setVisible(false);
                    keyWordLabel.setVisible(false);
                }
                repaint();
                pack();
            }
            if (( e.getSource()) == ok) {
                if(isAdmin.isSelected()){
                    registrationController.checkIin(new String(passwordField.getPassword()), firstNameField.getText(),secondNameField.getText(),loginField.getText(),keyWordField.getText(),true);
                }else  registrationController.checkIin(new String(passwordField.getPassword()), firstNameField.getText(),secondNameField.getText(),loginField.getText(),keyWordField.getText(),false);
            }
            if (( e.getSource()) == cancel) {
               registrationController.cancel();
            }
        }
    }



    public void setState(String state){
        this.state.setText(state);
    }

    public void clearFields(){
        passwordField.setText("");
        firstNameField.setText("");
        loginField.setText("");
        secondNameField.setText("");
        keyWordField.setText("");
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getSecondName() {
        return secondNameField.getText();
    }

    public String getKeyWordField() {
        return keyWordField.getText();
    }
}
