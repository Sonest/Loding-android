package com.olycloud.view;

import com.olycloud.progressbar.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundProgressBarWidthProgress extends
		HorizontalProgressbarWithProgress {
	private int mRadius = dp2px(20);
	private int mMaxPaintWidth;

	public RoundProgressBarWidthProgress(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		mReachHeight = (int) (mUnReachHeight * 2.5f);
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.RoundProgressBarWidthProgress);

		mRadius = (int) ta.getDimension(
				R.styleable.RoundProgressBarWidthProgress_radius, mRadius);

		ta.recycle();
		mPaint.setStyle(Style.STROKE);
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		mPaint.setStrokeCap(Cap.ROUND);
		

	}

	public RoundProgressBarWidthProgress(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundProgressBarWidthProgress(Context context) {
		this(context, null);
	}
	@Override
	protected synchronized void onMeasure(int widthMeasureSpec,
			int heightMeasureSpec) {
		mMaxPaintWidth = Math.max(mReachHeight, mUnReachHeight);
		//Ä¬ÈÏpaddingÒ»ÖÂ
		int expect = mRadius * 2+ mMaxPaintWidth +getPaddingLeft()+getPaddingRight();
		int width = resolveSize(expect, widthMeasureSpec);
		int height = resolveSize(expect, heightMeasureSpec);

		int readWidth = Math.min(width, height);
		mRadius = (readWidth - getPaddingLeft() - getPaddingRight()-mMaxPaintWidth)/2;
		setMeasuredDimension(readWidth, readWidth);
		
	}
	@Override
	protected synchronized void onDraw(Canvas canvas) {
		String text = getProgress()+"%";
		float textWidth = mPaint.measureText(text);
		float textHeight = (mPaint.descent()+mPaint.ascent())/2;
		canvas.save();
		canvas.translate(getPaddingLeft()+mMaxPaintWidth/2,getPaddingTop()+mMaxPaintWidth/2);
		mPaint.setStyle(Style.STROKE);
		//draw unreach bar
		mPaint.setColor(mUnReachColor);
		mPaint.setStrokeWidth(mUnReachHeight);
		canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
		//drap reach bar 
		mPaint.setColor(mReachColor);
		mPaint.setStrokeWidth(mReachHeight);
		
		float sweepAngle = getProgress()*1.0f/getMax()*360;
		canvas.drawArc(new RectF(0,0,mRadius*2,mRadius*2),0,sweepAngle, false, mPaint);
		//draw text
		mPaint.setColor(mTextColor);
		mPaint.setStyle(Style.FILL);
		
		canvas.drawText(text, mRadius-textWidth/2,mRadius-textHeight, mPaint);
		
		canvas.restore();
		
		
	
	}

}
