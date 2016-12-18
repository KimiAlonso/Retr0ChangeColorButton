package com.zbd.retr0changecolorbutton.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;



public class CircleChangeColorButton extends Button {

    private int beforeColor;
    private int afterColor;
    private float radius;
    private float beforeRadius;
    private float afterRadius = 0;

    private int mWidth;
    private int mHeight;

    private Handler mHandler;

    private Paint beforePaint = new Paint();
    private Paint afterPaint = new Paint();

    private int buttonStatus = 0;

    public CircleChangeColorButton(Context context) {
        super(context);
    }

    public void setColor(int beforeColor,int afterColor,float radius){
        this.beforeColor = beforeColor;
        this.afterColor = afterColor;
        this.radius = radius;
        beforeRadius = radius;
        initPaint(beforeColor,afterColor);
        initChange();
    }

    public void changeButtonStatus(){
        if (buttonStatus == 0){
            buttonStatus = 1;
        }else {
            buttonStatus = 0;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2,mHeight/2);


        if (buttonStatus == 0){
            canvas.drawCircle(0,0,beforeRadius,beforePaint);
            canvas.drawCircle(0,0,afterRadius,afterPaint);
        }else {
            canvas.drawCircle(0,0,beforeRadius,afterPaint);
            canvas.drawCircle(0,0,afterRadius,beforePaint);
        }
    }

    public void initChange(){
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(afterRadius < radius){
                    afterRadius = afterRadius + (radius/10);
                    invalidate();
                    mHandler.sendEmptyMessageDelayed(0,1);
                }
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            mHandler.sendEmptyMessageDelayed(0,40);
            changeButtonStatus();
            Log.e(String.valueOf(buttonStatus),"t");
            afterRadius = 0;
        }
        return super.onTouchEvent(event);
    }

    public void initPaint(int beforeColor, int afterColor){
        beforePaint.setColor(beforeColor);
        beforePaint.setStyle(Paint.Style.FILL);
        beforePaint.setStrokeWidth(5f);
        beforePaint.setAntiAlias(true);
        afterPaint.setColor(afterColor);
        afterPaint.setStyle(Paint.Style.FILL);
        afterPaint.setStrokeWidth(1f);
        afterPaint.setAntiAlias(true);
    }

    @Override
    public void setBackground(Drawable background) {

    }

    @Override
    public void setBackgroundColor(int color) {

    }
}
