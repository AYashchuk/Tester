package view.viewComponents;

import controller.MainUserController;

import javax.swing.*;

public abstract class MainJPanel extends JPanel{
    protected JLabel jlogin;
    protected MainUserController mainUserController;
    protected String login;
    protected MainJPanel(String login, MainUserController mainUserController) {
        super();
        this.login = login;
        jlogin = new JLabel(login);
        this.mainUserController = mainUserController;
    }

    public void setLogin(String login) {
        this.login = login;
        jlogin.setText(login);
        repaint();
    }
}
