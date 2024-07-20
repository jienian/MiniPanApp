package com.nim.carsspeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class CustomSpeedometerView extends View {
    private Bitmap background;
    private Bitmap needle;
    private float needleAngle = -135;  // 初始角度
    private OnSpeedChangeListener speedChangeListener;

    public interface OnSpeedChangeListener {
        void onSpeedChanged(float newSpeed);
    }

    public CustomSpeedometerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initResources(context);
    }

    private void initResources(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.clock);
        needle = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg_01);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        canvas.drawBitmap(background, centerX - ((float) background.getWidth() / 2), centerY - ((float) background.getHeight() / 2), null);

        canvas.save();
        canvas.rotate(needleAngle, centerX, centerY);
        canvas.drawBitmap(needle, centerX - ((float) needle.getWidth() / 2), centerY - ((float) needle.getHeight() / 2), null);
        canvas.restore();
    }

    public void setSpeed(float speed) {
        needleAngle = -135 + (speed / 7000f) * 270;
        invalidate();

        if (speedChangeListener != null) {
            speedChangeListener.onSpeedChanged(speed);
        }
    }

    public void setOnSpeedChangeListener(OnSpeedChangeListener listener) {
        this.speedChangeListener = listener;
    }
}