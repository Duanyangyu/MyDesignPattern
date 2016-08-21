package com.duanyy.mydesignpattern.producer;

/**
 * Created by Duanyy on 2016/8/21.
 */
public class ConsumerRunnable implements Runnable {

    private DataStorge mDataStorge;
    private int count;

    public ConsumerRunnable(DataStorge mDataStorge) {
        this.mDataStorge = mDataStorge;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        mDataStorge.consume(count);
    }

}
