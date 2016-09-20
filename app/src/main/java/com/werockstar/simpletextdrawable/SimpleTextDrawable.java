package com.werockstar.simpletextdrawable;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class SimpleTextDrawable extends Drawable {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String mMessage;

    public SimpleTextDrawable(String message) {
        this.mMessage = message;
        paint.setColor(Color.RED);
        paint.setTextSize(90);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(mMessage, 0, paint.getTextSize(), paint);
    }

    @Override
    public void setAlpha(int alpha) {
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
