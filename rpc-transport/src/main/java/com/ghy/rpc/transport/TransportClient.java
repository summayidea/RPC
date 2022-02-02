package com.ghy.rpc.transport;
//1.创建连接
//2.发送数据，并且等待响应
//3.关闭连接

import com.ghy.rpc.Peer;

import java.io.InputStream;

public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
