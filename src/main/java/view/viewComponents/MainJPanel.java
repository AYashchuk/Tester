package view.viewComponents;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

public abstract class MainJPanel extends JPanel{
    protected JComboBox comboBox = new JComboBox();
    protected java.util.List<Checkbox> questions;
    protected JLabel question = new JLabel("<html><h2>Question .................... ?</h2></html>");
    protected Checkbox checkbox1 = new Checkbox("answer 1");
    protected Checkbox checkbox2 = new Checkbox("answer 2");
    protected Checkbox checkbox3 = new Checkbox("answer 3");
    protected Checkbox checkbox4 = new Checkbox("answer 4");
    protected Checkbox checkbox5 = new Checkbox("answer 5");
    protected Checkbox checkbox6 = new Checkbox("answer 6");
    protected JButton next = new JButton("next");
    protected JButton prev = new JButton("prev");
    protected JButton start = new JButton("start test");
    protected JButton logout = new JButton("logout");
    protected JButton connect = new JButton("connect on server");
    protected JProgressBar progressBar = new JProgressBar();
    protected JLabel jlogin;
    protected String login;


    protected MainJPanel(String login) {
        super();
        this.login = login;
        jlogin = new JLabel(login);

        questions = new ArrayList<Checkbox>();
        questions.add(checkbox1);
        questions.add(checkbox2);
        questions.add(checkbox3);
        questions.add(checkbox4);
        questions.add(checkbox5);
        questions.add(checkbox6);

        setLayout(new BorderLayout());

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




    }

    protected abstract JComponent createWestPanel();

    protected abstract JComponent createEastJPanel();

    protected abstract Box createSouthPanel();

    protected abstract Box createNorthPanel();

    protected abstract Box createCenterPanel();

    protected abstract void addListeners();


    public void setLogin(String login) {
        this.login = login;
        jlogin.setText(login);
        repaint();
    }
}
