package com.example.student.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by student on 12/8/15.
 */
public class Panel extends SurfaceView implements SurfaceHolder.Callback{
    //GLOBAL VARIABLES
    Paint paint;
    private CanvasThread canvasthread;
    //Variable used to hold our bitmap


    public Panel(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub

        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(), this);
        setFocusable(true);
       paint = new Paint();



    }




    public Panel(Context context) {
        super(context);
        getHolder().addCallback(this);
        canvasthread = new CanvasThread(getHolder(), this);
        setFocusable(true);

    }


    @Override
    public void onDraw(Canvas canvas) {

        /**
        paint.setARGB(255, 255, 0, 0);
        //canvas.drawColor(Color.BLACK);
        canvas.drawCircle(200f, 200f, 30, paint);
    **/
         }

    public void update() {


    }



    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        canvasthread.setRunning(true);
        canvasthread.start();


    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        boolean retry = true;
        canvasthread.setRunning(false);
        while (retry) {
            try {
                canvasthread.join();
                retry = false;
            } catch (InterruptedException e) {
                // we will try it again and again...
            }
        }





    }


}