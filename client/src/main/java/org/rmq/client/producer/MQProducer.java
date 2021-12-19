package org.rmq.client.producer;

public interface MQProducer {

    void start();

    void shutdown();

    void send(final String msg);

}
