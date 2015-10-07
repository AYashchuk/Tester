package controller.mainUserController;

public interface MainUserController {
    boolean connectOnServer(String ip, int port);
    boolean testConnection();
    void disconnectFromServer();
}
