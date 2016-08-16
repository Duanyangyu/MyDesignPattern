package com.duanyy.mydesignpattern.observer;

import java.util.ArrayList;

/**
 * Created by Duanyy on 2016/8/13.
 */
public abstract class Subject {

    protected ArrayList<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer){
        if (observer != null) {
            observerList.add(observer);
        }
    }

    public void detach(Observer observer){
        if (observer != null) {
            observerList.remove(observer);
        }
    }

    public void notifyAllObserver(String change){
        if (observerList != null) {
            for (Observer o : observerList){
                o.update(change);
            }
        }
    }

}
