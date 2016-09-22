package com.werockstar.simpledrawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class RoundBitmapDrawable extends Drawable {

    private Bitmap mBitmap;
    private int mRadius;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF destinationRectF = new RectF();

    public RoundBitmapDrawable(Bitmap bitmap, int radius) {
        this.mRadius = radius;
        configBitmap(bitmap);
    }

    private void configBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        Shader shader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        invalidateSelf();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(destinationRectF, mRadius, mRadius, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        destinationRectF.set(bounds);
    }
}
