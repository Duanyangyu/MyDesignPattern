package com.duanyy.mydesignpattern.producer;

/**
 * Created by Duanyy on 2016/8/21.
 */
public class ProducerRunnable implements Runnable {

    private DataStorge mDataStorge;
    private int count;

    public ProducerRunnable(DataStorge mDataStorge) {
        this.mDataStorge = mDataStorge;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        mDataStorge.produce(count);
    }

}
