package com.example.sakkhispot.ummoagent;

public class Subscribers {

    String subscriberName;
    boolean selection = false;

    public Subscribers(String subscriberName, boolean selection){
        this.subscriberName = subscriberName;
        this.selection = selection;
    }

    public boolean isSelection() {
        return selection;
    }
}
