package com.ghy.rpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {
    @Test
    public void decode(){
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("ghy");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);

        assertNotNull(bytes);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes,TestBean.class);

        assertEquals(bean.getName(),bean2.getName());
        assertEquals(bean.getAge(),bean2.getAge());
    }
}