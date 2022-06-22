package com.wq.hashmap;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomHashMapImplTest {
    public final CustomHashMapImpl<String,String> customHashMap =new CustomHashMapImpl<>();

    @BeforeEach
    public void init(){
        customHashMap.put("k1","v1");
        customHashMap.put("k2","v2");
        customHashMap.put("k3","v3");
    }

    @Test
    public void test(){
        Assertions.assertEquals("v1",customHashMap.get("k1"));
}
}
