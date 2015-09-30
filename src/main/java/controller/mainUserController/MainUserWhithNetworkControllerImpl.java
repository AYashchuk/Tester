package controller.mainUserController;

import dao.QuestionDao;
import util.Networking;

public class MainUserWhithNetworkControllerImpl implements MainUserController {
    private Networking networkConnection;
    private QuestionDao questionDao;

    public MainUserWhithNetworkControllerImpl(Networking networkConnection, QuestionDao questionDao) {
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
