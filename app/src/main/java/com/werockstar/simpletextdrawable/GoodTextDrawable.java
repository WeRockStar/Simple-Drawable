package com.werockstar.simpletextdrawable;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

public class GoodTextDrawable extends Drawable {

    private TextPaint mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private String mMessage;
    private StaticLayout mStaticLayout;

    public GoodTextDrawable(String message) {
        this.mMessage = message;
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(90);
        mStaticLayout = new StaticLayout(mMessage, mPaint, (int) mPaint.measureText(mMessage), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
    }

    @Override
    public void draw(Canvas canvas) {
        mStaticLayout.draw(canvas);
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

    @Override
    protected void onBoundsChange(Rect bounds) {
        mStaticLayout = new StaticLayout(mMessage, mPaint, bounds.width(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
    }
}
