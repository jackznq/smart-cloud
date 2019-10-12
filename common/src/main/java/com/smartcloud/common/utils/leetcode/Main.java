package com.smartcloud.common.utils.leetcode;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

import java.net.URL;

/**
 * @author andy
 * @ClassName Main
 * @date 2019-08-27 16:46
 * @description todo
 **/
public class Main {
    public static void main(String[] args) throws Throwable {

        String data = "{\n" +
                "    \"id\": 1337,\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"getData\",\n" +
                "    \"params\": []\n" +
                "}";
        JsonRpcHttpClient client = new JsonRpcHttpClient(

                new URL("http://localhost:8091/contract/template?"+data));
        Integer getData = client.invoke("getData", null, Integer.class);

        System.out.println(getData);
    }
}
