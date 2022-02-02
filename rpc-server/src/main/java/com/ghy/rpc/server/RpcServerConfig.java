package com.ghy.rpc.server;

import com.ghy.rpc.codec.Decoder;
import com.ghy.rpc.codec.Encoder;
import com.ghy.rpc.codec.JSONDecoder;
import com.ghy.rpc.codec.JSONEncoder;
import com.ghy.rpc.transport.HTTPTransportServer;
import com.ghy.rpc.transport.TransportServer;
import lombok.Data;

//server配置
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
