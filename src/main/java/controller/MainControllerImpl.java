package controller;

import dao.QuestionDao;
import util.Networking;

public class MainControllerImpl implements MainController {
    private Networking networkConnection;
    private QuestionDao questionDao;

    public MainControllerImpl(Networking networkConnection, QuestionDao questionDao) {
        this.networkConnection = networkConnection;
        this.questionDao = questionDao;
    }

    @Override
    public boolean connectOnServer() {
        return false;
    }

    @Override
    public boolean testConnection() {
        return false;
    }

    @Override
    public boolean disconnectFromServer() {
        return false;
    }

    public void setNetworkConnection(Networking networkConnection) {
        this.networkConnection = networkConnection;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public boolean isConnect(){
        return false;
    }


}
