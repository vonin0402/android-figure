package com.example.baby.myapplication;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Baby on 2016-04-15.
 */
@SuppressWarnings("serial")
public class Figure implements Serializable {
    private String name;
    private int figureSize;
    private int color;
    private int lineSize;

    Figure (String name, int figureSize, int color, int lineSize) {
        this.name = name;
        this.figureSize = figureSize;
        this.color = color;
        this.lineSize = lineSize;
    }

    void printData() {
        Log.d(this.getClass().getName(), "Figure Name : " + name + ", lineSize : " + lineSize);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLineSize() {
        return lineSize;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
    }

    public int getFigureSize() {
        return figureSize;
    }

    public void setFigureSize(int figureSize) {
        this.figureSize = figureSize;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
