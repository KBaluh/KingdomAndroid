package KBaluh.github.com.Entity.Bullets;

import KBaluh.github.com.Levels.Level;
import KBaluh.github.com.R;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class RocketExplosion implements IExplosion {

    private ArrayList<Bitmap> explosions = new ArrayList<Bitmap>();

    public RocketExplosion(Level level) {
        if (level == null) {
            return;
        }

        explosions.add(level.loadImage(R.drawable.expl1));
        explosions.add(level.loadImage(R.drawable.expl2));
        explosions.add(level.loadImage(R.drawable.expl3));
        explosions.add(level.loadImage(R.drawable.expl4));
        explosions.add(level.loadImage(R.drawable.expl5));
    }

    public int getFrames() {
        return 5;
    }

    public int getInterval() {
        return 3;
    }

    public Bitmap getImageByFrame(int frame) {
        return explosions.get(frame);
    }
}
