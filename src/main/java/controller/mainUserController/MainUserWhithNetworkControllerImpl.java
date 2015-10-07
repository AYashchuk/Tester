package controller.mainUserController;

import dao.QuestionDao;
import util.network.Client;
import util.network.ClientNetworking;

import java.io.IOException;

public class MainUserWhithNetworkControllerImpl implements MainUserController {
    private ClientNetworking networkConnection;
    private QuestionDao questionDao;

    public MainUserWhithNetworkControllerImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public boolean connectOnServer(String ip, int port) {
        if(networkConnection == null){
            try {
                Client client = new Client(ip, 8088);
                client.start();
                networkConnection = client;
                networkConnection.connectOnServer();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            disconnectFromServer();
            connectOnServer(ip,port);
        }


        return false;
    }

    @Override
    public boolean testConnection() {
        return false;
    }

    @Override
    public void disconnectFromServer() {
        networkConnection.disconnectFromServer();
        networkConnection = null;
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
