package com.belle.springsecurityjwt.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
    public static void main(String[] args) {
        try {
            String address = InetAddress.getLocalHost().getHostAddress().toString();
            System.out.println (address);
        } catch (UnknownHostException e) {
            e.printStackTrace ();
        }
    }
}
