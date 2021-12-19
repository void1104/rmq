package org.rmq.namesrv;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.rmq.remoting.RemotingService;
import org.rmq.remoting.netty.NettyRemotingServer;

public class NamesrvStartup {
    private static final Logger log = LoggerFactory.getLogger(NamesrvStartup.class);

    private RemotingService remotingService;

    public void start() throws Exception {
        this.remotingService = new NettyRemotingServer();
        remotingService.start();
        log.trace("rmq namesrv has start up...");
    }
}
