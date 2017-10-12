package org.liko.study;


import java.io.UnsupportedEncodingException;

public class Test {
    @org.junit.Test
    public void test() throws UnsupportedEncodingException {
//        String s = "李魁";
//        String s1 = new String(s.getBytes(), "UTF-8");
//        System.out.println(s1);
        String s2 = new String(s1.getBytes("UTF-8"), "ISO8859-1");
        System.out.println(s2);

        String s3 = new String(s2.getBytes("ISO8859-1"), "UTF-8");
        System.out.println(s3);
    }
}
