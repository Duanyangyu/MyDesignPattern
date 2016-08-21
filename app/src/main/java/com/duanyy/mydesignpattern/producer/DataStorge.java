package com.duanyy.mydesignpattern.producer;

import android.util.Log;

import com.duanyy.mydesignpattern.Tag;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Duanyy on 2016/8/21.
 * 数据缓冲区
 */
public class DataStorge {

    private int MAX = 100;

//    private BlockingDeque<Data> list;
    private LinkedList<Data> list;

    public DataStorge(){
//        list = new LinkedBlockingDeque<>(MAX);
        list = new LinkedList<>();
    }

    //生产数据
    public void produce(int count){
        synchronized (list){
            int size = list.size();
            if (size+count >= MAX){
                try {
                    list.wait();
                    Log.d(Tag.PRODUCER,"current storge size have not enough spact!");
                } catch (InterruptedException e) {
                    Log.d(Tag.PRODUCER,"exception happened when produce in DataStorge!");
                }
            }

            for (int i = 0; i < count; i++) {
                Data data = new Data();
                list.add(data);
            }
            Log.d(Tag.PRODUCER,"procuce  "+count+"  data, current storge size is: "+list.size());
            list.notifyAll();
        }
    }

    //消费数据
    public void consume(int count){

        synchronized (list){
            int size = list.size();
            if (size <= count){
                try {
                    list.wait();
                    Log.d(Tag.PRODUCER,"current storge size is: "+list.size()+", can not consume "+count+" data");
                } catch (InterruptedException e) {
                    Log.d(Tag.PRODUCER,"exception happened when consume in DataStorge!");
                }
            }

            for (int i = 0; i < count; i++) {
                list.remove();
            }
            Log.d(Tag.PRODUCER,"consume  "+count+"  data, current storge size is: "+list.size());
            list.notifyAll();
        }
    }

}
