package com.example.baby.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class MyView extends View {

    private float centerX, centerY;
    private String name;
    private int figureSize, lineSize;

    public MyView(Context context, String name, int figureSize, int lineSize) {
        super(context);
        this.name = name;
        this.figureSize = figureSize;
        this.lineSize = lineSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        Paint bgPaint = new Paint();
        bgPaint.setColor(Color.WHITE);

        int realSize = figureSize * 20;

        if (name.equals("Circle")) {
            int realCircleSize = realSize + lineSize * 2;
            canvas.drawCircle(centerX, centerY, realCircleSize, paint);
            canvas.drawCircle(centerX, centerY, realSize, bgPaint);
        } else if (name.equals("Rectangle")) {
            int realRectSize = figureSize * 20 + lineSize *  2;
            canvas.drawRect(centerX - realRectSize , centerY - realRectSize, centerX + realRectSize, centerY + realRectSize, paint);
            canvas.drawRect(centerX - realSize , centerY - realSize, centerX + realSize, centerY + realSize, bgPaint);
        } else if (name.equals("Triangle")) {
            paint.setStrokeWidth(lineSize * 2);
            canvas.drawLine(centerX, centerY - realSize, centerX - realSize, centerY + realSize, paint);
            canvas.drawLine(centerX, centerY - realSize, centerX + realSize, centerY + realSize, paint);
            canvas.drawLine(centerX - realSize, centerY + realSize, centerX + realSize, centerY + realSize, paint);

        }


    }

    public void changeData(String name, int figureSize,int lineSize) {

        this.name = name;
        this.figureSize = figureSize;
        this.lineSize = lineSize;
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
    }


}
