package com.duanyy.mydesignpattern.observer;

import android.util.Log;

import com.duanyy.mydesignpattern.Tag;

/**
 * Created by Duanyy on 2016/8/16.
 * 发布者，被观察者
 */
public class ConcreteObserver extends Observer {

    @Override
    void update(String change) {
        Log.d(Tag.OBSERVER,"current subject is: "+change);
    }

}
