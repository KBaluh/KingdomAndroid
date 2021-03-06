package KBaluh.github.com.Entity.Bullets;

import KBaluh.github.com.Art;
import KBaluh.github.com.Entity.Direction;
import KBaluh.github.com.Entity.Team;
import KBaluh.github.com.R;
import android.graphics.Bitmap;

public class SeaMine extends Bullet {

    private Bitmap image;

    private static final int speed = 3;
    private static final int damage = 40;
    private static final Direction dir = Direction.UP;

    private static int ticks = 1;
    private int tickCount = ticks;

    public SeaMine(int x, int y) {
        super(x, y, speed, dir, damage, Team.TeamOne);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        image = level.loadImage(R.drawable.sea_mine);
    }

    @Override
    public void tick() {
        if (isHit()) {
            return;
        }

        if (tickCount == 0) {
            setY(getY() - speed);
            tickCount = ticks;
        } else {
            tickCount--;
        }
    }

    @Override
    public void hit() {
        super.hit();
        Explosion explosion = new Explosion(new RocketExplosion(level), getX(), getY());
        level.addEntity(explosion);
    }

    @Override
    public Bitmap getImage() {
        return image;
    }

    @Override
    public int getImageWidth() {
        int width = super.getImageWidth();
        if (width > 10) {
            width -= 10;
        }
        return width - 10;
    }

    @Override
    public int getImageHeight() {
        int height = super.getImageHeight();
        if (height > 10) {
            height -= 10;
        }
        return height - 10;
    }
}
