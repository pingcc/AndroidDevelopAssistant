package com.user.fun.library.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {


    /** 加密的MD5字符串**/
//    private static final String MD5String = "lo0.1l@g9v#";

    /**
     * 获取MD5 值
     */
    private static String getMD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5Utils");
            digest.update(content.getBytes());
            return getHashString(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMD5Psd(String str,String MD5String){
       return MD5Utils.getMD5(str + MD5String);
    }

    /**
     * 通过指定的byte数组对摘要进行最后的更新，然后完成摘要计算
     *
     * @param digest
     * @return
     */
    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }
}
