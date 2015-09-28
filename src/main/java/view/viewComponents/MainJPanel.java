package view.viewComponents;

import controller.MainController;

import javax.swing.*;

public abstract class MainJPanel extends JPanel{
    protected JLabel jlogin;
    protected MainController mainController;
    protected String login;
    protected MainJPanel(String login,MainController mainController) {
        super();
        this.login = login;
        jlogin = new JLabel(login);
        this.mainController = mainController;
    }

    public void setLogin(String login) {
        this.login = login;
        jlogin.setText(login);
        repaint();
    }
}
