package view.viewComponents;

import controller.mainAdminController.MainAdminController;
import controller.mainUserController.MainUserWithoutNetworkController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminJPanel extends MainJPanel {
    private MainAdminController mainAdminController;
    private JTabbedPane tabbedPane;
    private JLabel ip = new JLabel("Servers IP:192.168.1.2");
    private JButton startStop = new JButton("Start server");
    private JLabel state = new JLabel("State: ");
    private JButton addQ = new JButton("add Question");
    private JButton deleteQ = new JButton("delete Question");
    private JButton editQ = new JButton("edit Question");
    private  JButton save = new JButton("Save");




    public AdminJPanel(String login, MainAdminController mainAdminController) {
        super(login);
        setSize(800,600);
        this.mainAdminController = mainAdminController;



        add(createNorthPanel(), BorderLayout.NORTH);
        add(createWestPanel(), BorderLayout.WEST);
        add(createCenterPanel(),BorderLayout.CENTER);
        add(createSouthPanel(),BorderLayout.SOUTH);
        addListeners();
    }



    @Override
    protected JComponent createWestPanel() {
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));

        mainBox.add(ip);
        mainBox.add(startStop);
        mainBox.add(state);

        add(createEastJPanel(), BorderLayout.EAST);
        return mainBox;
    }

    @Override
    protected JComponent createEastJPanel() {
        JPanel mainjPanel = new JPanel(new BorderLayout());


        JComponent jPanel = new JPanel(new GridLayout(4,1));
        jPanel.add(addQ);
        jPanel.add(deleteQ);
        jPanel.add(editQ);
        jPanel.add(save);
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
        startStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainAdminController.startServer();
            }
        });
        addQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

    public MainAdminController getMainAdminController() {
        return mainAdminController;
    }
}
