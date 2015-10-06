package controller.mainUserController;

import dao.QuestionDao;
import util.network.ClientNetworking;

public class MainUserWhithNetworkControllerImpl implements MainUserController {
    private ClientNetworking networkConnection;
    private QuestionDao questionDao;

    public MainUserWhithNetworkControllerImpl(ClientNetworking networkConnection, QuestionDao questionDao) {
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

    public void setNetworkConnection(ClientNetworking networkConnection) {
        this.networkConnection = networkConnection;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public boolean isConnect(){
        return false;
    }


}
