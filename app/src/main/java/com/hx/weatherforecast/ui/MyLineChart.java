package com.hx.weatherforecast.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hx.weatherforecast.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLineChart extends View {

    private Paint mPaint;

    private Paint mTextPaint;

    private Paint mPointPaint;

    private List<Integer> mPointData;

    private int mTextColor = Color.BLUE;

    private int mLineColor= Color.BLACK;

    private int mStrokeWidth =10;

    private int mPointRadius;
    /**
     * 最高最低点
     */
    private int maxLow = 0;
    private int maxHeight = 0;


    /**
     * 默认的长宽高的长度
     */
    private int defaultWidth = dp2px(200);
    private int defaultHeight = dp2px(100);


    /**
     * 文字的大小
     */
    private int textSize=dp2px(12);

    /**
     *圆点的半径
     */
    public MyLineChart(Context context) {
        this(context, null);
    }

    public MyLineChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLineChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyLineChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray arrays=context.obtainStyledAttributes(attrs,R.styleable.MyLineChart);
        mLineColor=arrays.getColor(R.styleable.MyLineChart_line_color, Color.BLACK);
        mTextColor=arrays.getColor(R.styleable.MyLineChart_text_color, Color.BLUE);
        mStrokeWidth=arrays.getDimensionPixelOffset(R.styleable.MyLineChart_line_stroke_width,10);
        mPointRadius=arrays.getDimensionPixelOffset(R.styleable.MyLineChart_point_radius,10);
        textSize=arrays.getDimensionPixelOffset(R.styleable.MyLineChart_text_size,12);
        arrays.recycle();
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPointData.isEmpty()) {
            return;
        }
        int pointCount = mPointData.size();
        int height = getHeight();
        int width = getWidth();
        int little = dp2px(5);
        int scan = (height -little*2) / (maxHeight - maxLow);
        int distance = (width-little*2) / (pointCount - 1);
        Path linePath = new Path();
        for (int i = 0; i < pointCount; i++) {
            int temp = (mPointData.get(i)-maxLow) * scan;
            int y=height-temp-little;
            int x=distance*i+little;
            if (i == 0) {
                drawText(canvas,x,y,mPointData.get(i),i);
               //移到第一个点的位置
                linePath.moveTo(x, y);
                canvas.drawCircle(x,y,mPointRadius,mPointPaint);
                continue;
            }
            linePath.lineTo(x, y);
            drawText(canvas,x,y,mPointData.get(i),i);
            canvas.drawCircle(x,y,mPointRadius,mPointPaint);
        }
        canvas.drawPath(linePath, mPaint);
        for (int i = 0; i < pointCount; i++) {
            int temp = (mPointData.get(i)-maxLow) * scan;
            int y=height-temp-little;
            int x=distance*i+little;
            drawText(canvas,x,y,mPointData.get(i),i);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));

    }

    /**
     * 画文本
     */
    private void drawText(Canvas canvas, int x, int y, int num, int index) {
        String temp = num + "℃";
        //这个处理是为了将温度的文字放到线的下面
        if (index==mPointData.size()-1){
            x= (int) (x-textSize*2);
        }else if ((index==mPointData.size()-2)||((mPointData.get(index)==maxHeight)&&index!=0)){
            x= (int) (x-textSize);
        }else{
            x= (int) (x+textSize/2);
        }
        if (maxHeight==mPointData.get(index)){
            y=(int) (y+textSize*2);
        }else{
            if(y<(textSize*2)){
                y=(int) (y+textSize*2);
            }else{
                y= (int) (y-textSize/2);
            }
        }
        canvas.drawText(temp, x, y, mTextPaint);
    }


    /**
     * 测量高
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultHeight;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    /**
     * 测量宽
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultWidth;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        return result;

    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        mPaint.setColor(mLineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(textSize);
        mPointPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPointPaint.setColor(mLineColor);
        //mPointPaint.setStrokeWidth(mStrokeWidth);
        mPointPaint.setAntiAlias(true);
        mPointData = new ArrayList<>();
    }


    private int dp2px(int dp) {
        float scan = getResources().getDisplayMetrics().density;
        return (int) (scan * dp + 0.5f);
    }

    public List<Integer> getPointData() {
        return mPointData;
    }

    public void setPointData(List<Integer> mPointData) {
        this.mPointData = mPointData;
        if (mPointData.isEmpty()) {
            return;
        }
        List<Integer> tempList = new ArrayList<>(mPointData);
        Collections.sort(tempList);
        maxLow = tempList.get(0);
        maxHeight = tempList.get(tempList.size() - 1);
        requestLayout();//相当于调用onMeasure方法
        invalidate();//相当于调用onDraw的方法
    }


}
