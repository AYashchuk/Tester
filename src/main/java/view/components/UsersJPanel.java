package view.components;

import view.LoginFrame;
import view.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UsersJPanel extends MainJPanel {
    private JComboBox comboBox = new JComboBox();
    private java.util.List<Checkbox> questions = new ArrayList<>();

    private JLabel question = new JLabel("<html><h2>Question .................... ?</h2></html>");
    private Checkbox checkbox1 = new Checkbox("answer 1");
    private Checkbox checkbox2 = new Checkbox("answer 2");
    private Checkbox checkbox3 = new Checkbox("answer 3");
    private Checkbox checkbox4 = new Checkbox("answer 4");
    private Checkbox checkbox5 = new Checkbox("answer 5");
    private Checkbox checkbox6 = new Checkbox("answer 6");
    private JButton next = new JButton("next");
    private JButton prev = new JButton("prev");
    private JButton start = new JButton("start test");
    private JButton logout = new JButton("logout");
    private JButton connect = new JButton("connect on server");
    private JProgressBar progressBar = new JProgressBar();


    public UsersJPanel(String login) {
        super(login);
        questions.add(checkbox1);
        questions.add(checkbox2);
        questions.add(checkbox3);
        questions.add(checkbox4);
        questions.add(checkbox5);
        questions.add(checkbox6);

        setSize(new Dimension(400, 600));
        setLayout(new BorderLayout());
        addListeners();
//        JPanel jPanelNorth = new JPanel();
//        jPanelNorth.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        jPanelNorth.add(createNorthPanel());
//
//        JPanel jPanelCenter = new JPanel();
//        jPanelCenter.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        jPanelCenter.add(createCenterPanel());
//
//
//        JPanel jPanelSouth = new JPanel();
//        jPanelSouth.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        jPanelSouth.add(createSouthPanel());



        add(createNorthPanel(), BorderLayout.NORTH);
        add(createWestPanel(), BorderLayout.WEST);
        add(createCenterPanel(),BorderLayout.CENTER);
        add(createSouthPanel(),BorderLayout.SOUTH);

    }

    private JScrollPane createWestPanel() {
        JScrollPane jScrollPane = new JScrollPane();
        for(int i=0;i<questions.size();i++){
            jScrollPane.add(questions.get(i));
        }
        return jScrollPane;
    }

    private Box createSouthPanel() {
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

    private void addListeners() {
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame test = new JFrame("Connect on server");
                test.setResizable(false);
                test.setVisible(true);
                test.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                JLabel state = new JLabel("State: ");
                JButton testConnection = new JButton("test");
                testConnection.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        state.setText("connect");
                    }
                });
                JButton ok = new JButton("Ok");
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.setVisible(false);

                    }
                });
                JButton disconnect = new JButton("Disconncet");
                disconnect.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });


                // Настраиваем первую горизонтальную панель (для ввода логина)
                Box box = Box.createVerticalBox();
                Box box2 = Box.createHorizontalBox();
                Box box1 = Box.createHorizontalBox();
                JLabel loginLabel = new JLabel("Enter servers ip:");
                JTextField ip = new JTextField("192.168.1.3    ");
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
                mainBox.add(Box.createHorizontalGlue());
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(state);

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

    private Box createCenterPanel() {
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

    private Box createNorthPanel(){
        Box box = Box.createVerticalBox();
        Box horBox = Box.createHorizontalBox();
        JPanel jpanel = new JPanel();
        horBox.add(Box.createHorizontalStrut(10));
        horBox.add(new JLabel("<html><h2>Select Test:"+"</html></h2>"));
        horBox.add(Box.createHorizontalStrut(5));
        horBox.add(comboBox);
        horBox.add(Box.createHorizontalStrut(5));
        horBox.add(connect);
        horBox.add(Box.createHorizontalStrut(200));
        horBox.add(new JLabel("<html><h2>You enter on login: " + super.login +"</html></h2>"));
        horBox.add(Box.createHorizontalStrut(5));
        horBox.add(logout);
        box.add(horBox);
        horBox.add(Box.createVerticalStrut(10));
        box.add(new JLabel("<html> <h1>Test name: Java<h1></html>"));
        return box;
    }
}
