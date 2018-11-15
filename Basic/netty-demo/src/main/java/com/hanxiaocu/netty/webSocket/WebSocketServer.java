package com.hanxiaocu.netty.webSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/15 4:28 PM
 */
@Slf4j
public class WebSocketServer {

	public static void run(int port) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		ServerBootstrap bootstrap =  new ServerBootstrap();
		bootstrap.group(bossGroup,workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						pipeline.addLast("http-codec",new HttpServerCodec());
						pipeline.addLast("aggregator",new HttpObjectAggregator(65536));//聚合器 整理 消息组装
						pipeline.addLast("http-chunked",new ChunkedWriteHandler());//通信支持 分块
						pipeline.addLast("handler",new WebSocketServerHandler());
					}
				});
	}

}
