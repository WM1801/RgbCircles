package com.example.my.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Администратор on 16.12.2015.
 */
public class GameManager {


    private CanvasView canvasView;
    private  static  int width;
    private  static  int height;
    private MainCircle mainCircle;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();

    }



    private void initMainCircle() {
        mainCircle = new MainCircle(width/2, height/2);
    }


    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }
}
