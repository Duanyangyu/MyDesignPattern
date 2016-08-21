package com.duanyy.mydesignpattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.duanyy.mydesignpattern.observer.ObserverActivity;
import com.duanyy.mydesignpattern.producer.ProducerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({
            R.id.btn_pattern_observer,
            R.id.btn_pattern_factory,
            R.id.btn_pattern_producer
    })
    public void btnObserver(View button){
        int id = button.getId();
        Intent intent = new Intent();
        switch (id){
            case R.id.btn_pattern_observer:
                intent.setClass(this, ObserverActivity.class);
                break;
            case R.id.btn_pattern_factory:
                intent.setClass(this, ObserverActivity.class);
                break;
            case R.id.btn_pattern_producer:
                intent.setClass(this, ProducerActivity.class);
                break;
        }
        startActivity(intent);

    }






}
