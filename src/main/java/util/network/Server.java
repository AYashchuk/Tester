package util.network;

import domain.Massage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            networksProcess.stop();
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
        private List<Socket> clients = new ArrayList<>();

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
            log.info("start running...");
            System.out.println(serverSocket.getInetAddress().getHostAddress());
            System.out.println("waiting new client...");
            while (!isInterrupted()){
                log.info("in while");
                try {
                    currentClient = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            log.info("stop running.");
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


    private class ClientProcess extends Thread{
        private Scanner scanner;
        ObjectOutputStream oos;

        ClientProcess(Socket socket){
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run(){

        }
    }
}
