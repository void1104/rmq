package org.rmq.remoting;

public interface RemotingClient extends RemotingService {

    void invokeSync(String request);
}
