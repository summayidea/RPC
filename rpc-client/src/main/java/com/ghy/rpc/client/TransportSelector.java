package com.ghy.rpc.client;

import com.ghy.rpc.Peer;
import com.ghy.rpc.transport.TransportClient;

import java.util.List;

//表示选择哪个server去连接
public interface TransportSelector {
    //初始化selector
    void init(List<Peer> peers, int count,
              Class<? extends  TransportClient> clazz);

    //选择一个transport与server做交互
    TransportClient select();
    //释放用完的client
    void release(TransportClient client);
    void close();
}
