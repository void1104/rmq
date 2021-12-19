package org.rmq.client.consumer;

public interface MQConsumer {

    void start();

    void shutdown();

    void subscribe();
}
