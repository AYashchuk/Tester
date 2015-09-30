package view;

import controller.loginController.LoginController;
import controller.loginController.LoginControllerImpl;
import dao.UserDaoImpl;
import exception.IncorrectDataUserInputException;
import exception.IncorrectPasswordException;
import exception.NoContainsUserException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JButton exit;
    private JButton ok;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JButton reg;
    private CurrentActionListener actionListener = new CurrentActionListener();
    private static LoginFrame loginFrame;
    private LoginController loginController;
    private JLabel loginLabel;
    JLabel passwordLabel;

    public static LoginFrame getInstance(){
        if(loginFrame == null){
            loginFrame = new LoginFrame(new LoginControllerImpl(new UserDaoImpl()));
            return loginFrame;
        }else
        return loginFrame;
    }

    private LoginFrame(LoginController loginController) {
        super("Enter in Tester system");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setContentPane(setContent());
        pack();
        setLocationRelativeTo(null);
        this.loginController = loginController;
    }


    private Box setContent(){
        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);


        // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);


        // Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        ok = new JButton("OK");
        ok.addActionListener(actionListener);
        exit = new JButton("Exit");
        exit.addActionListener(actionListener);
        reg = new JButton("Registration");
        reg.addActionListener(actionListener);
        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(exit);
        box3.add(reg);

        // Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        return mainBox;
    }

    public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(true);
                getInstance();
            }
        });
    }



    class CurrentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JButton) e.getSource()) == ok) {
                try {
                    loginController.login(loginField.getText(),new String(passwordField.getPassword()));
                } catch (NoContainsUserException e1) {
                    e1.printStackTrace();
                } catch (IncorrectPasswordException e1) {
                    e1.printStackTrace();
                } catch (IncorrectDataUserInputException e1) {
                    e1.printStackTrace();
                }
            }
            if (((JButton) e.getSource()) == exit) {
                loginController.exit();
            }
            if( ((JButton)e.getSource()) == reg){
                loginController.registration();
            }
        }
    }

    public void clearFields(){
        passwordField.setText("");
        loginField.setText("");
        loginLabel.setText("Login:");
        passwordLabel.setText("Password:");
    }

    public void setRedTextLogin(){
        loginLabel.setText("<html><font color = red>"+"Login:"+"</font>");
    }
    public void setRedTextPassword(){
        passwordLabel.setText("<html><font color = red>"+"Password:"+"</font>");
    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
}
