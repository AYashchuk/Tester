package util.network;

import domain.Massage;

public class Client extends Thread implements ClientNetworking {



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
    public Massage receiveMassage() {
        return null;
    }

    @Override
    public boolean sendMassage(Massage massage) {
        return false;
    }

    @Override
    public void run(){
        while(isInterrupted()){


        }
    }
}
