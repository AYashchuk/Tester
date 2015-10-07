package util.network;

import domain.Massage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client extends Thread implements ClientNetworking {
    private Socket socket;
    private final String HOST;
    private final int PORT;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(String host, int port) throws IOException {
            this.HOST = host;
            this.PORT = port;

    }


    @Override
    public boolean connectOnServer() {
        try {
            socket = new Socket(HOST,PORT);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.writeObject(new Massage("%test",null,null));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean disconnectFromServer() {
        if(socket != null){
            try {
                oos.writeObject(new Massage("%discon",null,null));
                oos.close();
                ois.close();
                socket.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

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
        connectOnServer();
        while(isInterrupted()){


        }
    }
}
