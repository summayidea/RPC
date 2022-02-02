package com.ghy.rpc.server;

import com.ghy.rpc.Request;
import com.ghy.rpc.ServiceDescriptor;
import com.ghy.rpc.common.utils.ReflectionUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

public class ServiceManagerTest {
    ServiceManager sm;
    @Before
    public void init(){
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void register(){
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup(){
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class,method);
        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis =  sm.lookup(request);
        assertNotNull(sis);

    }

}