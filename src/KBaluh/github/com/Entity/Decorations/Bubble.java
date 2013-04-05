package KBaluh.github.com.Entity.Decorations;

import KBaluh.github.com.Entity.Entity;
import KBaluh.github.com.R;
import android.graphics.Bitmap;

/**
 * User: KBaluh
 * Date time: 16.10.12 17:41
 */
public class Bubble extends Entity {

    private Bitmap imageSmall;
    private Bitmap imageMiddle;
    private Bitmap imageBig;
    private Bitmap image;

    private int x;
    private int y;
    private int speed;
    private int dy;

    public BubbleType type = BubbleType.Small;

    public Bubble(int x, int y, int speed, BubbleType type) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.type = type;
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        imageSmall = level.loadImage(R.drawable.bubble_small);
        imageMiddle = level.loadImage(R.drawable.bubble_middle);
        imageBig = level.loadImage(R.drawable.bubble_large);

        if (type == BubbleType.Big) {
            image = imageBig;
        } else if (type == BubbleType.Middle) {
            image = imageMiddle;
        } else {
            image = imageSmall;
        }
    }

    public void tick() {
        speed += dy;
        y -= speed;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
