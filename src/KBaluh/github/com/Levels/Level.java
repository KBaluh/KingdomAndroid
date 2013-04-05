package KBaluh.github.com.Levels;

import KBaluh.github.com.Entity.Entity;
import KBaluh.github.com.Entity.Spawners.Spawner;
import KBaluh.github.com.GameScreen;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.SensorEventListener;
import android.view.MotionEvent;

/**
 * User: KBaluh
 * Date time: 16.10.12 17:26
 */
public abstract class Level implements Runnable, SensorEventListener {

    private Context context;
    public GameScreen gameScreen;

    public Level(Context context, GameScreen gameScreen) {
        this.context = context;
        this.gameScreen = gameScreen;
    }

    public int getScreenHeight() {
        return gameScreen.getHeight();
    }

    public int getScreenWidth() {
        return gameScreen.getWidth();
    }

    public void run() {
    }

    public Bitmap loadImage(int id) {
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    public abstract void addSpawner(Spawner spawner);
    public abstract void addEntityBack(Entity entity);
    public abstract void addEntity(Entity entity);
    public abstract void addEntityPop(Entity entity);
    public abstract void removeEntity(Entity entity);
    public abstract boolean onTouchEvent(MotionEvent e);
    public abstract void paint(Canvas g);
    public abstract void tick();
    public abstract boolean canMove(int x, int y, int width, int height);
    public abstract boolean levelIsDone();
    public abstract void levelStop();
    public abstract int getPlayerScores();
    public abstract int getLevelNumber();
    public abstract int getPlayerX();
    public abstract int getPlayerY();
}
