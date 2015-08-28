package view;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    static UserDao userDao = new UserDaoImpl();

    public LoginFrame() {

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().add(new LoginPanel(new GridLayout(3, 3)));
        pack();
    }

    public static void main(String [] args){
        new LoginFrame();
        userDao.create(new User("Andrew","Yashchuk","andrew","14892"));
    }



    public class LoginPanel extends JPanel{
        public LoginPanel(LayoutManager layout) {
            super(layout);
            add(new JLabel("Login:"));
            add(new JTextField(10));
            add(new JLabel("Password:"));
            add(new JTextField(10));
            add(new JButton("Log in"));
        }
    }

}
