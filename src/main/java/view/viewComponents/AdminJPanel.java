package view.viewComponents;

import controller.mainAdminController.MainAdminController;
import controller.mainUserController.MainUserWithoutNetworkController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminJPanel extends MainJPanel {
    private MainAdminController mainAdminController;
    private JTabbedPane tabbedPane;
    private JLabel ip = new JLabel("Servers IP:");
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
        add(createEastJPanel(), BorderLayout.EAST);
        addListeners();
    }



    @Override
    protected JComponent createWestPanel() {
        JPanel mainjPanel = new JPanel(new BorderLayout());


        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(ip);
        mainBox.add(startStop);
        mainBox.add(state);
        JPanel serversPanel = new JPanel();
        serversPanel.setBorder(new TitledBorder("server control"));
        serversPanel.add(mainBox);


        JPanel verticalJpanel = new JPanel();
        verticalJpanel.setLayout(new BoxLayout(verticalJpanel, BoxLayout.Y_AXIS));
        for(int i =0 ; i< 100; i++){
            JButton jButton = new JButton("Button " + i);
            jButton.setAlignmentX(CENTER_ALIGNMENT);
            verticalJpanel.add(jButton);
        }
        JScrollPane jScrollPane = new JScrollPane(verticalJpanel);

        mainjPanel.add(serversPanel,BorderLayout.NORTH);
        mainjPanel.add(jScrollPane,BorderLayout.CENTER);

        return mainjPanel;
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
                mainAdminController.startStopServer();
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

    public void setIp(String ip) {
        this.ip.setText(ip);
    }
}
