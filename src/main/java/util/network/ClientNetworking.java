package util.network;

import domain.Massage;

public interface ClientNetworking {
    boolean connectOnServer();
    boolean disconnectFromServer();
    boolean testConnection();
    Massage receiveMassage();
    boolean sendMassage(Massage massage);

}
