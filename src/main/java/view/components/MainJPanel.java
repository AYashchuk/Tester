package view.components;

import javax.swing.*;

public abstract class MainJPanel extends JPanel{
    protected JLabel jlogin;
    protected String login;
    protected MainJPanel(String login) {
        super();
        this.login = login;
        jlogin = new JLabel(login);
    }

    public void setLogin(String login) {
        this.login = login;
        jlogin.setText(login);
        repaint();
    }
}
