package com.example.graphicsexample5;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.Random;

public class GraphicsView extends View {
    private Paint p1;
    private int objColor[] = {Color.RED, Color.GREEN, Color.BLUE};
    private Bitmap image;
    private String str = "Android";
    private float xPic, yPic;
    private int width = 1080, height = 1920;
    private Random rnd = new Random();

    public GraphicsView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        p1 = new Paint();
        p1.setStyle(Paint.Style.STROKE);
        p1.setStrokeWidth(5);
        image = BitmapFactory.decodeResource(getResources(),

                R.drawable.robot);

        xPic = 200;
        yPic = 300;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        str = "X = " + event.getX() + ", Y = " + event.getY();
        xPic = event.getX();
        yPic = event.getY();
        invalidate();
        return (true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int n, x, y;
// วาดสี่เหลี่ยม
        n = (int) (Math.random() * 3);
        p1.setColor(objColor[n]);
        x = rnd.nextInt(width);
        y = rnd.nextInt(height);
        canvas.drawRect(x, y, x + 100, y + 100, p1);

// วาดวงกลม
        n = rnd.nextInt(3);
        p1.setColor(objColor[n]);
        x = rnd.nextInt(width);
        y = rnd.nextInt(height);
        canvas.drawCircle(x, y, 100, p1);
// วาดข้อความ
        p1.setColor(Color.BLACK);
        p1.setTextSize(50);
        x = 20;
        y = 60;
        canvas.drawText(str, x, y, p1);
// draw picture
        canvas.drawBitmap(image, xPic, yPic, null);
    }
}