package KBaluh.github.com.Entity.Bullets;

import android.graphics.Bitmap;

/**
 * User: KBaluh
 * Date time: 17.10.12 16:26
 */
public interface IExplosion {
    int getFrames();
    int getInterval();
    Bitmap getImageByFrame(int frame);
}
