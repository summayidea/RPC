package com.ghy.rpc.client;

import com.ghy.rpc.codec.Decoder;
import com.ghy.rpc.codec.Encoder;
import com.ghy.rpc.common.utils.ReflectionUtils;
import com.sun.deploy.util.ReflectionUtil;

import java.lang.reflect.Proxy;

public class RpcClient {
    private RpcClinetConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClinetConfig());
    }

    public RpcClient(RpcClinetConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );
    }
    public <T> T getProxy(Class<T> clazz){
        return (T)Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
