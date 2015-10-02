package controller.mainAdminController;

import util.network.ServerNetworking;

public class MainAdminControllerImpl implements MainAdminController{
    private ServerNetworking networking;

    public MainAdminControllerImpl(ServerNetworking networking) {
        this.networking = networking;
    }


    @Override
    public void startStopServer() {
        networking.startStopServer();
    }

    @Override
    public void addQuestion() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void saveChange() {

    }

    @Override
    public void editQuestion() {

    }


    public ServerNetworking getNetworking() {
        return networking;
    }

    public void setNetworking(ServerNetworking networking) {
        this.networking = networking;
    }
}
