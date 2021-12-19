package org.rmq.remoting.netty;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.net.SocketAddress;

public class NettyRemotingClient {
    private static final Logger log = LoggerFactory.getLogger(NettyRemotingClient.class);

    public void sendSync(String addr, String request) {

        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture cf = bootstrap.connect(addr, 8888);
        Channel channel = cf.channel();

        final SocketAddress sAddr = channel.remoteAddress();
        channel.writeAndFlush(request).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                log.trace("send a request to channel <" + sAddr + ">");
            }
        });
    }
}
