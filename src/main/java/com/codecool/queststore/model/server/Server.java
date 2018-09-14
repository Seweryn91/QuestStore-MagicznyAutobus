package com.codecool.queststore.model.server;

import com.codecool.queststore.controller.server.httphandler.*;
import com.codecool.queststore.controller.server.httphandler.QuestHandler;
import com.codecool.queststore.controller.server.httphandler.ProfileHandler;
import com.codecool.queststore.model.server.session.SessionPool;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    private HttpServer server;

    public void run() throws IOException {
        server = HttpServer.create(new InetSocketAddress(5432), 0);
        setContext(server);
        server.setExecutor(null);
        new SessionPool();
        server.start();
    }

    // Overload to run server on desired port
    public void run(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        setContext(server);
        server.setExecutor(null);
        server.start();
    }

    private void setContext(HttpServer server){
        server.createContext("/", new LoginHandler());
        server.createContext("/profile", new ProfileHandler());
        server.createContext("/logout", new LogoutHandler());
        server.createContext("/static", new StaticHandler());
        server.createContext("/quests", new QuestHandler());
        server.createContext("/list-mentors", new MentorsHandler());
        server.createContext("/list-students", new StudentsHandler());
        server.createContext("/class", new ClassHandler());
        server.createContext("/shop", new StoreHandler());
    }

    public void stop(){
        server.stop(0);
    }
}
