package com.reedmi.enjoy.thrift.server;

import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import com.reedmi.enjoy.thrift.AdditionService;
import com.reedmi.enjoy.thrift.AdditionServiceHandler;

public class Server {

    public static void StartsimpleServer(AdditionService.Processor<AdditionServiceHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
//             TServer server = new TThreadPoolServer(new
//             TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartsimpleServer(new AdditionService.Processor<AdditionServiceHandler>(
                new AdditionServiceHandler()));
    }

}
