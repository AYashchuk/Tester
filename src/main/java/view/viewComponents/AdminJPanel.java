package view.viewComponents;

import controller.mainAdminController.MainAdminController;
import controller.mainUserController.MainUserWithoutNetworkController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    protected JComponent createWestPanel() {
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));

        mainBox.add(new JLabel("Servers IP:192.168.1.2"));
        mainBox.add(new JButton("Start Server"));
        mainBox.add(new JLabel("State: "));

        add(createEastJPanel(), BorderLayout.EAST);
        return mainBox;
    }

    @Override
    protected JComponent createEastJPanel() {
        JPanel mainjPanel = new JPanel(new BorderLayout());


        JComponent jPanel = new JPanel(new GridLayout(4,1));
        jPanel.add(new JButton("add Question"));
        jPanel.add(new JButton("delete Question"));
        jPanel.add(new JButton("edit Question"));
        jPanel.add(new JButton("Save"));
        mainjPanel.add(jPanel,BorderLayout.NORTH);


        return mainjPanel;
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
        Box box =Box.createVerticalBox();
        box.add(new UsersJPanel(login,new MainUserWithoutNetworkController(),true));
        return box;
    }

    @Override
    protected void addListeners() {

    }


    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

    public MainAdminController getMainAdminController() {
        return mainAdminController;
    }
}
