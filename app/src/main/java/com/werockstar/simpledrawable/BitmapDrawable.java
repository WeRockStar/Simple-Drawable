package com.werockstar.simpledrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class BitmapDrawable extends Drawable {

    Bitmap bitmap;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BitmapDrawable(Bitmap bitmap) {
        configBitmap(bitmap);
    }

    private void configBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, getBounds(), paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }
}
