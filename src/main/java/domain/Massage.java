package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Massage implements Serializable {
    private String systemMSG;
    private List<Question> question;
    private User user;
    private String date;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.hh:mm");

    public Massage(String systemMSG, List<Question> question, User user) {
        this.systemMSG = systemMSG;
        this.question = question;
        this.user = user;
        this.date = format.format(new Date());
    }

    public Massage(String systemMSG, User user) {
        this.systemMSG = systemMSG;
        this.user = user;
        this.date = format.format(new Date());
    }

    public Massage(String systemMSG, List<Question> question) {
        this.systemMSG = systemMSG;
        this.question = question;
        this.date = format.format(new Date());
    }

    public Massage(String systemMSG) {
        this.systemMSG = systemMSG;
        this.date = format.format(new Date());
    }


    @Override
    public String toString(){
        String s = "[sysMSG = " + systemMSG+"] ";
        if(user != null) s += "[user = " + user.login + "] ";
        s += "[date = " + date + "]";
        return s;
    }



}
