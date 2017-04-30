package com.app.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by 知らないのセカイ on 2017/4/30.
 */

public class MyView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
//        Btn_Reset = (Button) LayoutInflater.from(getContext()).inflate(R.layout.activity_main,null).findViewById(R.id.Reset);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);


        setOnTouchListener(this);

    }


    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
     draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    private Path path=null;
    private Paint paint=null;

    private void draw(){
        Canvas canvas = getHolder().lockCanvas();

        paint.setAntiAlias(true);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path,paint);
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                paint.setTextSize(2000);
                draw();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                paint.setTextSize(2000);
                draw();
                break;
        }
        return true;
    }
    public  void Reset(){
        path.reset();
        draw();

    }
}
