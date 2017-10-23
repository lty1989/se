package com.se.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by lty on 2017-10-12.
 */
public class LinkedHashMapTest {


    public static void main(String[] args) {
        LinkedHashMap<String,String>  lhm = new LinkedHashMap<>();
        lhm.put("1","1");
        String value = lhm.put("2","2");
        HashMap<String,String> hm = null;
        hm.put("","");
        System.out.println(value);
    }

}
