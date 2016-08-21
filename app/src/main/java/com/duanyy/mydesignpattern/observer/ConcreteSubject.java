package com.duanyy.mydesignpattern.observer;

import android.util.Log;

import com.duanyy.mydesignpattern.Tag;

/**
 * Created by Duanyy on 2016/8/13.
 * 发布者，被观察者
 */
public class ConcreteSubject extends Subject {

    private String state;

    public ConcreteSubject(String state){
        this.state = state;
        Log.d(Tag.OBSERVER,"subject is: "+state);
    }

    public void change(String change){
        this.state = change;
        notifyAllObserver(change);
    }

}
