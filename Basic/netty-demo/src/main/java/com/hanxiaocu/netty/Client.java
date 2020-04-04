package com.hanxiaocu.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/15 11:18 AM
 */
public class Client {

	private static class ClientHandler extends ChannelHandlerAdapter {
		private byte[] req;




		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			super.exceptionCaught(ctx, cause);
			ctx.close();
		}
	}


	public static String test() {
		String str = "hello";
		try {
			return str;
		}finally {
			str = "imooc";
		}
	}
}



