package com.siifi.infos.main;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器，channel 注册后，会执行里面的相应的初始化方法
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通过socketChannel 去获得对应的管道
        ChannelPipeline channelPipeline=socketChannel.pipeline();
        //通过管道，添加hander
        //HttpServerCodec 是由netty自己提供的助手类，可以理解为拦截器
        //当请求到服务器，我们需要做解码，响应到客户端做编码
        channelPipeline.addLast("",new HttpServerCodec());
        //添加自定义的助手类，返回“hello world”
        channelPipeline.addLast("customHander",null);

    }
}
