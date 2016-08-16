package com.duanyy.mydesignpattern.observer;

import android.util.Log;

import com.duanyy.mydesignpattern.Tag;

/**
 * Created by Duanyy on 2016/8/16.
 */
public class ConcreteObserver extends Observer {

    @Override
    void update(String change) {
        Log.d(Tag.OBSERVER,change);
    }

}
