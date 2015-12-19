package com.example.my.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Администратор on 16.12.2015.
 */
public class GameManager {


    private CanvasView canvasView;
    private  static  int width;
    private  static  int height;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;




    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();

    }

    private void initEnemyCircles() {
        circles = new ArrayList<EnemyCircle>();
        for(int i= 0; i<10; i++)
        {
            EnemyCircle circle;
            circle = EnemyCircle.getRandomCircle();

            circles.add(circle);
        }
        calculateAndSetCirclesColor();

    }

    private void calculateAndSetCirclesColor() {
        for(EnemyCircle circle : circles){
            circle.setEnemyOrFoodColorDependson(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    private void initMainCircle() {
        mainCircle = new MainCircle(width/2, height/2);
    }


    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for(EnemyCircle circle : circles){
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
