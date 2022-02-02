package com.ghy.rpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class JSONEncoderTest {
    @Test
    public void encode(){
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("ghy");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);

        assertNotNull(bytes);
    }

}