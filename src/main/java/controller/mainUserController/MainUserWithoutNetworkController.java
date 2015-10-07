package controller.mainUserController;

public class MainUserWithoutNetworkController implements MainUserController {
    @Override
    public boolean connectOnServer(String ip, int port) {
        return false;
    }

    @Override
    public boolean testConnection() {
        return false;
    }

    @Override
    public void disconnectFromServer() {

    }
}
