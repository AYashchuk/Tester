package util.network;

import domain.Massage;

public interface ServerNetworking {
    void startStopServer();
    void stopServer();
    boolean testConnection();
    Massage receiveMassage();
    boolean sendMassage(Massage massage);
    String getCurrentIP();
}
