package view.viewComponents;

import controller.MainUserControllerImpl;
import dao.QuestionDaoImpl;
import util.NetworkConnection;

import javax.swing.*;

public class AdminsJPanel extends MainJPanel {
    JTabbedPane tabbedPane;
    public AdminsJPanel(String login) {
        super(login, new MainUserControllerImpl(new NetworkConnection(),new QuestionDaoImpl()));
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPane.add("Server",new JPanel().add(new JButton("sfff")));
        tabbedPane.add("Test administration",new UsersJPanel("sdf"));

    }
}
