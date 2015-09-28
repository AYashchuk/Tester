package view.viewComponents;

import controller.MainControllerImpl;
import dao.QuestionDaoImpl;
import util.NetworkConnection;

public class AdminsJPanel extends MainJPanel {
    public AdminsJPanel(String login) {
        super(login, new MainControllerImpl(new NetworkConnection(),new QuestionDaoImpl()));
    }
}
