package com.ghy.rpc.example;

import com.ghy.rpc.client.RpcClient;
import com.ghy.rpc.server.RpcServer;


public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}
