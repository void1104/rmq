package org.rmq.client.producer;

import org.rmq.remoting.netty.NettyRemotingClient;
import org.rmq.remoting.netty.NettyRemotingServer;

public class DefaultMQProducer implements MQProducer {

    private NettyRemotingClient client;

    public void start() {
        client = new NettyRemotingClient();
    }

    public void send(final String request) {
        String addr = "";
        client.sendSync(addr, request);
    }

    public void shutdown() {
        // do something close...
    }
}
