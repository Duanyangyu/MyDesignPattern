package com.duanyy.mydesignpattern.producer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.duanyy.mydesignpattern.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProducerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_producer)
    public void btnProducer(View view){

        DataStorge dataStorge = new DataStorge();
        ProducerRunnable producer1 = new ProducerRunnable(dataStorge);
        ProducerRunnable producer2 = new ProducerRunnable(dataStorge);
        ProducerRunnable producer3 = new ProducerRunnable(dataStorge);
        ConsumerRunnable consumer1 = new ConsumerRunnable(dataStorge);
        ConsumerRunnable consumer2 = new ConsumerRunnable(dataStorge);

        producer1.setCount(10);
        producer2.setCount(30);
        producer3.setCount(50);

        consumer1.setCount(40);
        consumer2.setCount(60);

        Handler handler = new Handler();
        handler.post(producer1);
        handler.post(producer2);
        handler.post(producer3);

        handler.post(consumer1);
        handler.post(consumer2);

    }

}
