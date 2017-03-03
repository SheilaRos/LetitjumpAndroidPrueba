package com.example.billy.jumpit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Bonk {

	private int frame;
	private Paint paint;
	private int x, y;
	private BitmapSet bitmapSet;

	public Bonk(BitmapSet bitmapSet) {
		this.bitmapSet = bitmapSet;
		frame = 0;
		paint = new Paint();
		x = 80;
		y = 208;
	}

	public void draw(Canvas canvas) {
		Bitmap sprite = bitmapSet.getBitmap(frame);
		frame++;
		if (frame == 4) frame = 0;
		canvas.drawBitmap(sprite, x, y, paint);
	}
}
