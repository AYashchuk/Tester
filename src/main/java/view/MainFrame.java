package view;

import controller.mainAdminController.MainAdminControllerImpl;
import controller.mainUserController.MainUserWhithNetworkControllerImpl;
import dao.QuestionDaoImpl;
import domain.User;
import util.network.Server;
import view.viewComponents.AdminJPanel;
import view.viewComponents.UsersJPanel;

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


    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public void setCurUser(User curUser) {
        this.setVisible(true);
        this.curUser = curUser;
        if(curUser.getIsAdmin()) jPanel = new AdminJPanel(curUser.getLogin(), new MainAdminControllerImpl(new Server()));
        else jPanel = new UsersJPanel(curUser.getLogin(),new MainUserWhithNetworkControllerImpl(new QuestionDaoImpl()),false);
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
