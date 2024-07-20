package com.nim.carsspeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

public class SpeedDigitView extends View {
    private Bitmap currentDigit;

    public SpeedDigitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDigit(context);
    }
    private void initDigit(Context context) {
        @SuppressLint("DiscouragedApi") int resourceId = getResources().getIdentifier("digit_0", "drawable", getContext().getPackageName());
        currentDigit = BitmapFactory.decodeResource(getResources(), resourceId);
        invalidate();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (currentDigit != null) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            canvas.drawBitmap(currentDigit, centerX - ((float) currentDigit.getWidth() / 2), centerY - ((float) currentDigit.getHeight() / 2), null);
        }
    }

    public void updateDigit(int speed) {
        String speedStr = String.valueOf(speed / 1000);
        @SuppressLint("DiscouragedApi") int resourceId = getResources().getIdentifier("digit_" + speedStr, "drawable", getContext().getPackageName());
        currentDigit = BitmapFactory.decodeResource(getResources(), resourceId);
    }
}