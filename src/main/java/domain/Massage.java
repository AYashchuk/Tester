package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Massage implements Serializable {
    private String systemMSG;
    private Question question;
    private User user;
    private String date;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.hh:mm");

    public Massage(String systemMSG, Question question, User user) {
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

    public Massage(String systemMSG, Question question) {
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
        return "[sysMSG = " + systemMSG + "]; [question = " + question.getText() + "]; " + "[date = " + date + "]" ;
    }



}
