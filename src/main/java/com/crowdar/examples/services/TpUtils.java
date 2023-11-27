package com.crowdar.examples.services;

public class TpUtils {
    public static void sleep(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
