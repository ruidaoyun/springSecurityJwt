package com.belle.springsecurityjwt.test;

import java.io.*;

public class OutStreamTest {
    public static void main(String[] args) {
        try {
            System.setOut (new PrintStream (new BufferedOutputStream (new FileOutputStream (new File ("C:\\Users\\14184\\Desktop\\out.doc"))),true));
            System.out.println ("hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }
}
