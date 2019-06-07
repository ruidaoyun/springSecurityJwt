package com.belle.springsecurityjwt.test;

import java.util.Arrays;
import java.util.List;

public class LomdbaTest {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        //System.out.println (players.get (0));
        //players.forEach ((player) -> System.out.println (player+","));
        players.forEach ((player)->System.out.println (player+","));
        //players.forEach (System.out::println);

    }
}
