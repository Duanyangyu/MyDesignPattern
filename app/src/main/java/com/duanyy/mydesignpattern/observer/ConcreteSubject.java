package com.duanyy.mydesignpattern.observer;

/**
 * Created by Duanyy on 2016/8/13.
 */
public class ConcreteSubject extends Subject {

    private String state;

    public ConcreteSubject(String state){
        this.state = state;
    }

    public void change(String change){
        this.state = change;
        notifyAllObserver(change);
    }

}
