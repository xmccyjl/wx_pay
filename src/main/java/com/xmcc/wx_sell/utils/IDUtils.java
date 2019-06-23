package com.xmcc.wx_sell.utils;

import java.util.UUID;
/**
 * @author khaleesi
 * @create 2019-06-23 20:26
 */
public class IDUtils {
    public static String createIdbyUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
