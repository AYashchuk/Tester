package view.viewComponents;

import controller.mainAdminController.MainAdminController;
import controller.mainUserController.MainUserWithoutNetworkController;

import javax.swing.*;
import java.awt.*;

public class AdminJPanel extends MainJPanel {
    private MainAdminController mainAdminController;
    private JTabbedPane tabbedPane;


    public AdminJPanel(String login, MainAdminController mainAdminController) {
        super(login);
        setSize(800,600);
        this.mainAdminController = mainAdminController;
    }



    @Override
    protected JScrollPane createWestPanel() {
        return new JScrollPane();
    }

    @Override
    protected Box createSouthPanel() {
        return Box.createHorizontalBox();
    }


    @Override
    protected Box createNorthPanel() {
        Box box = Box.createVerticalBox();
        Box horBox = Box.createHorizontalBox();
        JPanel jpanel = new JPanel();
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(Box.createHorizontalStrut(50));
        horBox.add(new JLabel("<html><h2>You enter on login: " + super.login +"</html></h2>"));
        horBox.add(Box.createHorizontalStrut(5));
        horBox.add(logout);
        box.add(horBox);
        return box;
    }

    @Override
    protected Box createCenterPanel() {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPane.setSize(800,600);
        tabbedPane.add("Server", createServerJPanel());
        tabbedPane.add("Tester user",new UsersJPanel(login,new MainUserWithoutNetworkController(),true));
        tabbedPane.add("Tester admins",new JButton("df"));

        add(tabbedPane);
        Box box = Box.createVerticalBox();
        box.add(tabbedPane);
        return box;
    }

    @Override
    protected void addListeners() {

    }

    private Component createServerJPanel() {
        Box box = Box.createVerticalBox();

        return new JButton("d");
    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

    public MainAdminController getMainAdminController() {
        return mainAdminController;
    }
}
