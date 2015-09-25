package view;

import dao.UserDao;
import dao.UserDaoImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private UserDao userDao = new UserDaoImpl();
    private JButton exit;
    private JButton ok;
    private JPasswordField passwordField;
    private JTextField loginField;
    private JButton reg;
    private CurrentActionListener actionListener = new CurrentActionListener();
    private static LoginFrame loginFrame;
    private JFrame mainFrame;

    public static LoginFrame getInstance(){
        if(loginFrame == null){
            loginFrame = new LoginFrame();
            return loginFrame;
        }else
        return loginFrame;
    }

    private LoginFrame() {
        super("Enter in Tester system");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setContentPane(setContent());
        pack();
        setLocationRelativeTo(null);
    }


    private Box setContent(){
        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);


        // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
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
        getInstance();
    }



    class CurrentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JButton) e.getSource()) == ok) {
                System.out.println("ok");

            }
            if (((JButton) e.getSource()) == exit) {
                System.exit(0);
            }
            if( ((JButton)e.getSource()) == reg){
                getInstance().setVisible(false);
                clearFields();
                RegistretionFrame.getInstance().setVisible(true);
            }
        }
    }

    public void clearFields(){
        passwordField.setText("");
        loginField.setText("");
    }
}
