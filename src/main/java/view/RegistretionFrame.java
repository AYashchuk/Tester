package view;


import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import exception.IncorectDataUserInputException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistretionFrame extends JFrame {
    private UserDao userDao = new UserDaoImpl();
    private static RegistretionFrame registretionFrame;
    private JPasswordField passwordField;
    private JButton ok;
    private JButton cancel;
    private JTextField firstNameField;
    private JTextField loginField;
    private JTextField secondNameField;
    private JTextField keyWordField;
    private JCheckBox isAdmin;
    private JLabel state;
    private CurrentActionListener actionListener = new CurrentActionListener();
    private JLabel keyWordLabel;
    private MainFrame mainFrame;

    private RegistretionFrame() throws HeadlessException {
        super("Registration in Tester");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        getContentPane().add(setContent(), BorderLayout.NORTH);
        getContentPane().add(state, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private Box setContent(){
        // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(10));
        box1.add(loginField);

        // Настраиваем Вторую горизонтальную панель
        Box box2 = Box.createHorizontalBox();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(15);
        box2.add(firstNameLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(firstNameField);

        // Настраиваем третью горизонтальную панель (для ввода логина)
        Box box3 = Box.createHorizontalBox();
        JLabel secondNameLabel = new JLabel("Surname:");
        secondNameField = new JTextField(15);
        box3.add(secondNameLabel);
        box3.add(Box.createHorizontalStrut(14));
        box3.add(secondNameField);


        // Настраиваем четвертую горизонтальную панель (для ввода пароля)
        Box box4 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        box4.add(passwordLabel);
        box4.add(Box.createHorizontalStrut(8));
        box4.add(passwordField);



        Box box5 = Box.createHorizontalBox();
        isAdmin = new JCheckBox("Are you Admin?");
        isAdmin.addActionListener(actionListener);
        box5.add(Box.createHorizontalGlue());
        box5.add(isAdmin);

        // Настраиваем четвертую горизонтальную панель (для ввода пароля)
        Box box6 = Box.createHorizontalBox();
        keyWordLabel = new JLabel("Keyword:");
        keyWordField = new JPasswordField(15);
        keyWordLabel.setVisible(false);
        keyWordField.setVisible(false);
        box6.add(keyWordLabel);
        box6.add(Box.createHorizontalStrut(8));
        box6.add(keyWordField);

        // Настраиваем пятую горизонтальную панель (с кнопками)
        Box box7 = Box.createHorizontalBox();
        ok = new JButton("OK");
        ok.addActionListener(actionListener);
        cancel = new JButton("Cancel");
        cancel.addActionListener(actionListener);
        box7.add(Box.createHorizontalGlue());
        box7.add(ok);
        box7.add(Box.createHorizontalStrut(6));
        box7.add(cancel);


        // Настраиваем третью горизонтальную панель (с кнопками)
/*      Box box6 = Box.createHorizontalBox();*/
        state = new JLabel(){
            @Override
            public void setText(String text){
                super.setText("State: " + text);
            }
        };

        state.setHorizontalAlignment(SwingConstants.LEFT);
        state.setPreferredSize(new Dimension(100, 16));
//        box6.add(Box.createHorizontalStrut(6));
//        box6.add(state);

        // Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
        // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box6);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box7);
        mainBox.add(Box.createVerticalStrut(12));

        return mainBox;
    }


    public static RegistretionFrame getInstance(){
        if(registretionFrame == null){
            registretionFrame = new RegistretionFrame();
            return registretionFrame;
        }else
            return registretionFrame;
    }


    class CurrentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() == isAdmin){
                if(isAdmin.isSelected()){
                    keyWordField.setVisible(true);
                    keyWordLabel.setVisible(true);
                }else{
                    keyWordField.setVisible(false);
                    keyWordLabel.setVisible(false);
                }
                repaint();
                pack();
            }
            if (( e.getSource()) == ok) {
                String pass = new String (passwordField.getPassword()).trim();
                String firstName = firstNameField.getText().trim();
                String lastName = secondNameField.getText().trim();
                String login = loginField.getText().trim();
                String keyword = keyWordField.getText().trim();
                try {
                    if(isAdmin.isSelected()){
                        checkCorectData(pass, firstName, lastName, login,keyword);
                        registion(pass, firstName, lastName, login,keyword);
                    }else {
                        checkCorectData(pass, firstName, lastName, login, null);
                        registion(pass, firstName, lastName, login, null);
                    }

                } catch (IncorectDataUserInputException e1) {
                    e1.printStackTrace();
                }
            }
            if (( e.getSource()) == cancel) {
                getInstance().setVisible(false);
                LoginFrame.getInstance().setVisible(true);
            }
        }
    }

    private void checkCorectData(String pass,String firstName,String lastName,String login,String keyword) throws IncorectDataUserInputException {
        if(pass.toCharArray().length == 0){
            state.setText("field password is empty");
            throw new IncorectDataUserInputException("field password is empty");
        }
        if(firstName.toCharArray().length == 0){
            state.setText("field first name is empty");
            throw new IncorectDataUserInputException("field first name is empty");
        }
        if(lastName.toCharArray().length == 0){
            state.setText("field last name is empty");
            throw new IncorectDataUserInputException("field surname is empty");
        }
        if(login.toCharArray().length == 0){
            state.setText("field login is empty");
            throw new IncorectDataUserInputException("field login is empty");
        }
        if(pass.toCharArray().length <=4){
            state.setText("password is short");
            throw new IncorectDataUserInputException("password is short");
        }if(login.toCharArray().length <=4){
            state.setText("login is short");
            throw new IncorectDataUserInputException("login is short");
        }if(keyword != null){
            if(!keyword.equals("admin")){
                state.setText("keyword incorrect");
                throw new IncorectDataUserInputException("keyword incorrect");
            }
        }

    }

    public void registion(String pass,String firstName,String lastName,String login, String keyword){
        User user;
        if(keyword != null) user = new User(firstName,lastName,login,pass,true);
        else  user = new User(firstName,lastName,login,pass);
        if(userDao.create(user)!= null){
            MainFrame mainFrame =  MainFrame.getInstance();
            mainFrame.setCurUser(user);
        }
        this.setVisible(false);

    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public JTextField getSecondNameField() {
        return secondNameField;
    }
}
