package com.example.demo;

public class MyStarter {
    private MyStarterProperties myproperties;

    public MyStarter() {
    }

    public MyStarter (MyStarterProperties myproperties) {
        this. myproperties = myproperties;
    }

    public String print(){
        System.out.println("arg: " + myproperties.getParameter());
        String s=myproperties.getParameter();
        return s;
    }
}