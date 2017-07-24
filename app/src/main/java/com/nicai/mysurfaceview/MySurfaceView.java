package com.nicai.mysurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Holger on 2017/7/21.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = MySurfaceView.class.getSimpleName().toString();
    private final SurfaceHolder surfaceHolder;
    private MyThread myThread;

    public MySurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated: ");
        myThread = new MyThread();
        isRun = true;
        myThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged: ");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed: ");
        isRun = false;
    }

    boolean isRun;

    class MyThread extends Thread {
        @Override
        public void run() {
            while (isRun) {
                drawSth();
            }
        }
    }

    private void drawSth() {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint paint = new Paint();
//        抗锯齿
//        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
//        画一个圆形
        canvas.drawCircle(100, 100, 30, paint);
//啦啦啦
//        哈哈哈
//        嘿嘿嘿123
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}
