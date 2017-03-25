package com.example.chengboying.mytimeline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chengboying on 2017/3/24.
 */

public class TimeLineView extends View {

  private int startX, endX,textStartX;
  private Paint linePaint;
  private Paint textPaint;
  private int viewHeight = 0;
  private int oneHeight;

  public TimeLineView(Context context) {
    super(context);
    initData();

  }



  public TimeLineView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    initData();
  }

  public TimeLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initData();
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    viewHeight = h;
    //把view高度25等分
    oneHeight = viewHeight / 25;
    //使用postInvalidate可以直接在线程中更新界面
    postInvalidate();

  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    for (int i = 1; i <= 24; i++){

      drawLine(canvas,oneHeight * i);

      if (i % 6 == 0) {
        drawText(canvas, oneHeight* i, i);
      }
    }
  }

  public void initData(){
    startX = 30;
    endX = 45;
    textStartX = 65;

    linePaint = new Paint();
    linePaint.setColor(Color.WHITE);
    linePaint.setStrokeWidth(1);

    textPaint = new Paint();
    textPaint.setColor(Color.WHITE);
    textPaint.setTextSize(30);
  }
//画线方法
  private void drawLine(Canvas canvas, int startY) {
    canvas.drawLine(startX, startY, endX, startY, linePaint);
  }
//写数字方法
  private void drawText(Canvas canvas, int startY, int value) {
    //startY 数字的y坐标
    canvas.drawText(value+"", textStartX, startY +15,textPaint);
  }


}
