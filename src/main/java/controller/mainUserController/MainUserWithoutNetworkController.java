package controller.mainUserController;

public class MainUserWithoutNetworkController implements MainUserController {
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
}
