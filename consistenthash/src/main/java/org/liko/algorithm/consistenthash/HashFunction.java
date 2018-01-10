package org.liko.algorithm.consistenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {
    private MessageDigest md5 = null;

    public long hash(String key) {
        if (md5 == null) {
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException("no md5 algrithm found.");
            }
        }

        md5.reset();
        md5.update(key.getBytes());
        byte[] bKey = md5.digest();
        long result = ((long) (bKey[3] & 0xff) << 24)
                            | ((long)(bKey[2] & 0xff) << 16
                                | ((long)(bKey[1] & 0xff) << 8) | (long) (bKey[0] & 0xff));
        return result & 0xffffffffL;
    }

    public static void main(String[] args) {
        HashFunction function = new HashFunction();
        System.out.println(function.hash("Liko"));
        System.out.println(function.hash("Liko"));
        System.out.println(function.hash("Liko"));
        System.out.println(function.hash("Liko"));
    }
}
