package util.network;

import domain.Massage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ServerNetworking {
    private static Logger log = Logger.getLogger(Server.class);
    private boolean isInterrupted = false;
    private NetworksProcess networksProcess;

    @Override
    public void startStopServer() {
        if(!isInterrupted){
            networksProcess = new NetworksProcess();
            isInterrupted = true;
        }else {
            networksProcess.interrupt();
            isInterrupted = false;
        }

    }


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


    private class NetworksProcess extends Thread{
        private ServerSocket serverSocket;
        private Socket currentClient;
        private final int PORT;

        public NetworksProcess() {
            PORT = 8088;
            log.info("Port: " + PORT);
            initServerSocket();
        }

        public NetworksProcess(int port) {
            PORT = port;
            log.info("Port: " + PORT);
            initServerSocket();
        }


        @Override
        public void run(){
            System.out.println(serverSocket.getInetAddress().getHostAddress());
            System.out.println("waiting new client...");
            while (!isInterrupted()){

                try {
                    if((currentClient = serverSocket.accept())!=null){
                        System.out.println("new client");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                if(serverSocket!=null) {
                    serverSocket.close();
                    System.out.println("connection closed");
                }else{
                    System.out.println("socket is empty");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        private void initServerSocket(){
            try {
                this.serverSocket = new ServerSocket(PORT);
                //setDaemon(true);
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
