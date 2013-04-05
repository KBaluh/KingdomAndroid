package KBaluh.github.com.Entity.Mobs;

import KBaluh.github.com.Entity.Direction;
import KBaluh.github.com.Entity.Team;
import KBaluh.github.com.R;
import KBaluh.github.com.Weapons.RocketGun;
import KBaluh.github.com.Weapons.Weapon;
import android.graphics.Bitmap;

import java.util.Random;

/**
 * Author: KBaluh
 * Date: 16.10.12:21:34
 */
public class HunterFish extends Mob {

    private Bitmap imageLeft;
    private Bitmap imageRight;

    private final int fishSpeed = 2;

    private static final float hp = 20;

    private int scores = 8;
    public HunterFish(int x, int y, Direction dir) {
        super(x, y, hp, Team.TeamTwo);
        setDir(dir);
        setSpeed(fishSpeed);

        Weapon weapon = new RocketGun(this);
        setWeapon(weapon);
        setShootDelayR(500, 100);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        imageLeft = level.loadImage(R.drawable.hunter_fish_left);
        imageRight = level.loadImage(R.drawable.hunter_fish_right);
    }

    public int getScores() {
        if (isRemoved()) {
            return 0;
        }
        return scores + (new Random().nextInt(scores / 2));
    }

    public Bitmap getImage() {
        if (getDir() == Direction.LEFT) {
            return imageLeft;
        } else {
            return  imageRight;
        }
    }
}
