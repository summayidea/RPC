package com.ghy.rpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReflectionUtilsTest {
    @Test
    public void newInstance(){
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }
    @Test
    public void getPublicMethod(){
        Method[] methods= ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);
        String mname = methods[0].getName();
        assertEquals("b",mname);
    }
    @Test
    public void invoke(){
        Method[] methods= ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        TestClass t = new TestClass();
        Object r = ReflectionUtils.invoke(t,b);
        assertEquals("b",r);
    }
}
