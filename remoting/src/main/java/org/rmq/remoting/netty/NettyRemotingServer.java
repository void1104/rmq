package org.rmq.remoting.netty;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.rmq.remoting.RemotingService;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;


public class NettyRemotingServer implements RemotingService {
    private final Logger log = LoggerFactory.getLogger(NettyRemotingServer.class);

    @Override
    public void start() {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(8888))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    ByteBuf resp = Unpooled.copiedBuffer("127.0.0.1", StandardCharsets.UTF_8);
                                    ctx.writeAndFlush(resp.duplicate());
                                }
                            });
                        }
                    });
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                log.error("shutdownGracefully err={}", e.getMessage(), e);
            }
        }
    }

    @Override
    public void shutdown() {

    }
}
