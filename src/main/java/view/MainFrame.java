package view;

import domain.User;
import view.components.AdminsJPanel;
import view.components.UsersJPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel jPanel;
    private User curUser;
    private static MainFrame mainFrame;

    private MainFrame() throws HeadlessException {
        super("Tester");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,450);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private Container setContent() {
        return null;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public void setCurUser(User curUser) {
        this.setVisible(true);
        this.curUser = curUser;
        if(curUser.getIsAdmin()) jPanel = new AdminsJPanel(curUser.getLogin());
        else jPanel = new UsersJPanel(curUser.getLogin());
        add(jPanel);
        validate();
        repaint();
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public User getCurUser() {
        return curUser;
    }

    public static MainFrame getInstance() {
        if(mainFrame == null) mainFrame = new MainFrame();
        return mainFrame;
    }

    public void logout(){
        getContentPane().removeAll();
    }
}
