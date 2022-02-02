package com.ghy.rpc.client;

import com.ghy.rpc.Peer;
import com.ghy.rpc.codec.Decoder;
import com.ghy.rpc.codec.Encoder;
import com.ghy.rpc.codec.JSONDecoder;
import com.ghy.rpc.codec.JSONEncoder;
import com.ghy.rpc.transport.HTTPTransportclient;
import com.ghy.rpc.transport.TransportClient;
import com.sun.xml.internal.ws.transport.http.client.HttpClientTransport;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
@Data
public class RpcClinetConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportclient.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass =
            RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1",3000)
    );

}
