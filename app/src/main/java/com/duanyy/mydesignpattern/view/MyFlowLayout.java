package com.duanyy.mydesignpattern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Duanyy on 2016/8/10.
 * 支持自动换行的viewgroup
 */
public class MyFlowLayout extends ViewGroup {

    private final static int MARGIN_HORIZONTAL = 5;//控件之间的水平间隔
    private final static int MARGIN_VERTICAL = 10;//控件之间的竖直间隔

    private final static String TAG = "ViewGroup";

    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int actualWidth = specWidth - 2*MARGIN_HORIZONTAL;//去掉margin后的实际width
        int x = 0;
        int y = 0;
        int row = 1;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight();

            x += childWidth + MARGIN_HORIZONTAL;
            if (x > actualWidth){
                x = childWidth;
                row++;
            }
            y = row * (childHeight+MARGIN_VERTICAL);

            Log.d(TAG,"width:"+childView.getMeasuredWidth()+", height:"+childView.getMeasuredHeight());
        }
        setMeasuredDimension(actualWidth,y);

    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {

        int actualWidth = right - left;
        int x = MARGIN_HORIZONTAL;
        int y = MARGIN_VERTICAL;
        int row = 1;

        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();
            x += width + MARGIN_HORIZONTAL;
            if (x > actualWidth){
                x = width + MARGIN_HORIZONTAL;
                row++;
            }
            y = row * (height + MARGIN_VERTICAL);

            if (i == 0){
                childView.layout(MARGIN_HORIZONTAL,MARGIN_VERTICAL,x-MARGIN_VERTICAL,y);
            }else {
                childView.layout(x-width,y-height,x,y);
            }
        }
    }
}
