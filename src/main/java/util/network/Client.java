package util.network;

import domain.Massage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client extends Thread implements ClientNetworking {
    private static Logger log = Logger.getLogger(Client.class);
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
            log.info("Create connection...");
            socket = new Socket(HOST,PORT);
            log.info("Connection create!");
            log.info("Create IOStreams...");
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            log.info("IOStreams is created! ");
            oos.writeObject(new Massage("%test",null,null));
            log.info("Massage send!");
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
