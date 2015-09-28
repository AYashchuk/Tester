package util;

import domain.Massage;

public class NetworkConnection implements Networking{
    @Override
    public boolean connectOnServer() {
        return false;
    }

    @Override
    public boolean disconnectFromServer() {
        return false;
    }

    @Override
    public boolean testConnection() {
        return false;
    }

    @Override
    public Massage receive() {
        return null;
    }

    @Override
    public boolean send(Massage massage) {
        return false;
    }
}
