package com.example.billy.jumpit;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Toast;

import com.example.billy.jumpit.BitmapSet;
import com.example.billy.jumpit.GameViewHistoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Scene {

    private String scene[];
    private Paint paint;
    private GameViewHistoria game;
    private BitmapSet bitmapSet;

    private int sceneWidth, sceneHeight;

    private static final String sceneChars = "-.<>";  // CANVIAR
    private static final int[] sceneIndexes =
            new int[] { 36, 23 };  // CANVIAR

    Scene(GameViewHistoria game) {
        this.game = game;
        this.bitmapSet = game.getBitmapSet();
        paint = new Paint();
    }

    public Scene(BitmapSet bitmapSet) {
        this.bitmapSet = game.getBitmapSet();
    }

    void loadFromFile(int resource) {
        InputStream res = game.getResources().openRawResource(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(res));
        List<String> lines = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                lines.add(line);
            }
            scene = lines.toArray(new String[0]);
            reader.close();
            sceneHeight = scene.length;
            sceneWidth = scene[0].length();
        }
        catch (IOException e) {
            Toast.makeText(game.getContext(), "Error loading scene:" +  e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    boolean isGround(int r, int c) {
        if (r < 0) return false;
        if (r >= sceneHeight) return false;
        if (c < 0) return false;
        if (c >= sceneWidth) return false;
        char sc = scene[r].charAt(c);
        return ("[#]<->".indexOf(sc) != -1);
    }
    boolean isWall(int r, int c) {
        if (r < 0) return false;
        if (r >= sceneHeight) return false;
        if (c < 0) return false;
        if (c >= sceneWidth) return false;
        char sc = scene[r].charAt(c);
        return ("[#]".indexOf(sc) != -1);
    }

    int getSceneWidth() { return sceneWidth; }
    int getSceneHeight() { return sceneHeight; }

    int getWidth() { return sceneWidth * 16; }
    int getHeight() { return sceneHeight * 16; }

    void draw(Canvas canvas) {
        if (scene == null) return;
        for(int y = 0; y < scene.length; y++) {
            for(int x = 0; x < scene[0].length(); x++) {
                Bitmap bitmap;
                char c = scene[y].charAt(x);
                int i = sceneChars.indexOf(c);
                int index = sceneIndexes[i];
                int bgIdx = 17;
                bitmap = bitmapSet.getBitmap(bgIdx);
                canvas.drawBitmap(bitmap, x*16, y*16, paint);
                if (index == 17) continue;
                bitmap = bitmapSet.getBitmap(index);
                canvas.drawBitmap(bitmap, x*16, y*16, paint);
            }
        }
    }
}
