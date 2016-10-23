package com.enterprise.module3;

public class Bootstrap {
    public static void main(String[] args) {
        Starter starter = new Starter();
        try {
            starter.starter(21);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        starter.getElements();
    }
}
