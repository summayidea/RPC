package com.ghy.rpc;

import lombok.Data;
//表示Rpc的一个请求
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
