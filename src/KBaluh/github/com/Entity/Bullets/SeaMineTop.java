package KBaluh.github.com.Entity.Bullets;

import KBaluh.github.com.Art;
import KBaluh.github.com.Entity.Direction;
import KBaluh.github.com.Entity.Team;
import KBaluh.github.com.R;
import android.graphics.Bitmap;

public class SeaMineTop extends Bullet {

    private static final int damage = 10;
    private static final int speed = 7;

    private Bitmap image;

    public SeaMineTop(int x, int y) {
        super(x, y, speed, Direction.DOWN, damage, Team.TeamTwo);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        image = level.loadImage(R.drawable.sea_mine_top);
    }

    public void tick() {
        super.tick();
        dx = 0;
        dy = 0;
    }

    @Override
    public Bitmap getImage() {
        return image;
    }

    @Override
    public void hit() {
        super.hit();
        level.addEntityPop(new Explosion(new RocketExplosion(level), getX(), getY()));
    }
}
