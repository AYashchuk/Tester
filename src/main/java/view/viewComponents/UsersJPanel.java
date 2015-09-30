package view.viewComponents;

import controller.mainUserController.MainUserController;
import view.LoginFrame;
import view.MainFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UsersJPanel extends MainJPanel {
    protected MainUserController mainUserController;
    private boolean isAdminCreated = false;

    public UsersJPanel(String login,  MainUserController mainUserController,Boolean isAdminCreated) {
        super(login);
        this.isAdminCreated = isAdminCreated;

        this.mainUserController = mainUserController;

        questions = new ArrayList<Checkbox>();
        questions.add(checkbox1);
        questions.add(checkbox2);
        questions.add(checkbox3);
        questions.add(checkbox4);
        questions.add(checkbox5);
        questions.add(checkbox6);

        setSize(new Dimension(400, 600));
        setLayout(new BorderLayout());
        addListeners();

        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jPanelNorth.add(createNorthPanel());

        JPanel jPanelCenter = new JPanel();
        //jPanelCenter.setVisible(false);
        jPanelCenter.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jPanelCenter.add(createCenterPanel());


        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jPanelSouth.add(createSouthPanel());



        add(jPanelNorth, BorderLayout.NORTH);
        add(createWestPanel(), BorderLayout.WEST);
        add(jPanelCenter,BorderLayout.CENTER);
        add(createSouthPanel(),BorderLayout.SOUTH);

    }

    @Override
    protected JScrollPane createWestPanel() {
        JScrollPane jScrollPane = new JScrollPane();
        Box box = Box.createVerticalBox();
        for(int i=0;i<30;i++){
            jScrollPane.add(new JButton("Button " + i));
            jScrollPane.add(Box.createVerticalStrut(3));
        }
        return jScrollPane;
    }

    @Override
    protected Box createSouthPanel() {
        prev.setEnabled(false);
        next.setEnabled(false);
        Box box = Box.createVerticalBox();
        Box horBox = Box.createHorizontalBox();
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(prev);
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(next);
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(start);


        box.add(Box.createVerticalStrut(20));
        box.add(progressBar);
        box.add(Box.createVerticalStrut(10));
        box.add(horBox);

        return box;
    }

    @Override
    protected void addListeners() {
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame test = new JFrame("Connect on server");
                final JButton ok = new JButton("Ok");
                test.setResizable(false);
                test.setVisible(true);
                test.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                final JLabel state = new JLabel("State: ");
                JButton testConnection = new JButton("test");
                testConnection.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mainUserController.testConnection()){
                            state.setText("<html><font color = green>Connection accept!"+"</font>");
                            ok.setEnabled(true);
                        }else{
                            state.setText("<html><font color = red>"+"Can`t connect on server...</font>");
                        }

                    }
                });

                ok.setEnabled(false);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.setVisible(false);
                    }
                });
                JButton disconnect = new JButton("Disconnect");
                disconnect.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(mainUserController.disconnectFromServer()) state.setText("<html><font color = green>"+"Disconnect...</font>");
                        else state.setText("<html><font color = red>"+"Connection error, try again...</font>");
                    }
                });


                // Настраиваем первую горизонтальную панель (для ввода логина)
                Box box = Box.createVerticalBox();
                Box box2 = Box.createHorizontalBox();
                Box box1 = Box.createHorizontalBox();
                JLabel loginLabel = new JLabel("Enter servers ip:");
                JTextField ip = new JTextField("192.168.1.3");
                box1.add(loginLabel);
                box1.add(Box.createHorizontalStrut(6));
                box1.add(ip);


                box2.add(ok);
                box2.add(Box.createHorizontalStrut(6));
                box2.add(testConnection);
                box2.add(Box.createHorizontalStrut(6));
                box2.add(disconnect);


                Box mainBox = Box.createVerticalBox();
                mainBox.setBorder(new EmptyBorder(12,12,12,12));
                mainBox.add(box1);
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(Box.createHorizontalGlue());
                mainBox.add(box2);

                Box box3 = Box.createHorizontalBox();
                box3.add(state);
                box3.add(Box.createHorizontalGlue());
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(box3);

                test.setContentPane(mainBox);
                test.setLocationRelativeTo(null);
                test.pack();
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setVisible(false);
                MainFrame.getInstance().logout();
                LoginFrame.getInstance().setVisible(true);
            }
        });



    }



    @Override
    protected Box createNorthPanel(){
        Box box = Box.createVerticalBox();
        Box horBox = Box.createHorizontalBox();
        JPanel jpanel = new JPanel();
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(new JLabel("<html><h2>Select Test:"+"</html></h2>"));
        horBox.add(Box.createHorizontalStrut(5));
        horBox.add(comboBox);
        if(isAdminCreated == false){
            horBox.add(Box.createHorizontalStrut(5));
            horBox.add(connect);
            horBox.add(Box.createHorizontalStrut(50));
            horBox.add(new JLabel("<html><h2>You enter on login: " + super.login +"</html></h2>"));
            horBox.add(Box.createHorizontalStrut(5));
            horBox.add(logout);
        }


        box.add(horBox);
        horBox.add(Box.createVerticalStrut(10));
        box.add(new JLabel("<html> <h1>Test name:<h1></html>"));
        return box;
    }

    @Override
    protected Box createCenterPanel() {
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(10));
        box.add(question);
        box.add(Box.createHorizontalGlue());
        box.add(Box.createVerticalStrut(20));


        Box horBox1 = Box.createHorizontalBox();
        horBox1.add(checkbox1);
        horBox1.add(Box.createHorizontalStrut(10));
        horBox1.add(checkbox2);

        Box horBox2 = Box.createHorizontalBox();
        horBox2.add(checkbox3);
        horBox2.add(Box.createHorizontalStrut(10));
        horBox2.add(checkbox4);

        Box horBox3 = Box.createHorizontalBox();
        horBox3.add(checkbox5);
        horBox3.add(Box.createHorizontalStrut(10));
        horBox3.add(checkbox6);

        Box horBox4 = Box.createHorizontalBox();
        horBox4.add(checkbox1);
        horBox4.add(Box.createHorizontalStrut(10));
        horBox4.add(checkbox2);

        box.add(Box.createVerticalStrut(10));
        box.add(horBox1);
        box.add(Box.createVerticalStrut(10));
        box.add(horBox2);
        box.add(Box.createVerticalStrut(10));
        box.add(horBox3);
        box.add(Box.createVerticalStrut(10));
        box.add(horBox4);
        return box;
    }
}
