package com.example.billy.jumpit.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Bonk extends Character{

	private int frame;
	private Paint paint;
	private int x, y;
	private int jumpVel;
	private BitmapSet bitmapSet;

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getJumpVel() {
		return jumpVel;
	}

	public void setJumpVel(int jumpVel) {
		this.jumpVel = jumpVel;
	}

	public Bonk(BitmapSet bitmapSet) {
		super(bitmapSet);
		this.bitmapSet = bitmapSet;
		frame = 0;
		paint = new Paint();
		x = 80;
		y = 208;
		jumpVel = 11;
	}

	public void draw(Canvas canvas) {
		Bitmap sprite = bitmapSet.getBitmap(frame);
		frame++;
		if (frame == 4) frame = 0;
		canvas.drawBitmap(sprite, x, y, paint);
	}
}
