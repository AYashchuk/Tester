package util.network;

import domain.Massage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
    public void stopServer() {

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
    public String getCurrentIP() {
        return "Servers IP: " + networksProcess.myLANIP + ":" + networksProcess.getPORT();
    }


    private class NetworksProcess extends Thread{
        private ServerSocket serverSocket;
        private Socket currentClient;
        private final int PORT;
        private List<Socket> clients = new ArrayList<Socket>();
        private InetAddress addr;
        private String myLANIP;


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
            log.info("Start server...");
            System.out.println(serverSocket.getInetAddress().getHostAddress());
            while (!isInterrupted()){
                try {
                    log.info("Server waiting new client...");
                    currentClient = serverSocket.accept();
                    log.info("New client connect!!!  "   + currentClient.getInetAddress());
                    ClientProcess clientProcess = new ClientProcess(currentClient);
                    log.info("Start new Client thread...");
                    clientProcess.start();
                    log.info("Clients thread start!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            log.info("stop running.");
        }

        private void initServerSocket(){
            try {
                addr = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            myLANIP = addr.getHostAddress();
            try {
                this.serverSocket = new ServerSocket(PORT);
                //setDaemon(true);
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public InetAddress getAddr() {
            return addr;
        }

        public String getMyLANIP() {
            return myLANIP;
        }

        public int getPORT() {
            return PORT;
        }
    }


    private class ClientProcess extends Thread{
        private Scanner scanner;
        private ObjectOutputStream oos;
        private ObjectInputStream ois;

        ClientProcess(Socket socket){
            try {
                log.info("Create IOStreams...");
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println(1);
                ois = new ObjectInputStream(socket.getInputStream());
                log.info("Create IOStreams is created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run(){

            Scanner scan = new Scanner(ois);
            while(!isInterrupted()){
                if(scan.hasNext()){
                    try {
                        Massage msg = (Massage)ois.readObject();
                        System.out.println(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
