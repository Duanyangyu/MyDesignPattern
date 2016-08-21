package com.duanyy.mydesignpattern.observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duanyy.mydesignpattern.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 观察者模式
 */
public class ObserverActivity extends AppCompatActivity {

    @BindView(R.id.tv_result)
    public TextView tv_result;

    @BindView(R.id.btn_observer)
    public Button btn_observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_observer)
    public void onClick(View view){
        ConcreteSubject concreteSubject = new ConcreteSubject("111");
        ConcreteObserver concreteObserver = new ConcreteObserver();
        concreteSubject.attach(concreteObserver);
        concreteSubject.change("222");
//        concreteSubject.detach(concreteObserver);
        concreteSubject.change("333");
    }

}
