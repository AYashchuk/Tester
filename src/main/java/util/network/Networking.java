package util.network;

import domain.Massage;

public interface Networking {
    boolean connectOnServer();
    boolean disconnectFromServer();
    boolean testConnection();
    Massage receive();
    boolean send(Massage massage);

}
