package org.rmq.broker;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BrokerStartup {
    private static final Logger log = LoggerFactory.getLogger(BrokerStartup.class);

    private BlockingQueue<String> queue;

    public void start(){
        this.queue = new ArrayBlockingQueue<>(1024);
        log.trace("rmq broker has start up...");
    }
}
