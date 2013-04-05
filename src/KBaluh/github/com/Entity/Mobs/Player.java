package KBaluh.github.com.Entity.Mobs;

import KBaluh.github.com.Entity.Direction;
import KBaluh.github.com.Entity.Team;
import KBaluh.github.com.R;
import KBaluh.github.com.Weapons.RocketGun;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

/**
 * Author: kostya
 * Date: 16.10.12:18:57
 */
public class Player extends Mob {
    private Bitmap imageLeft;
    private Bitmap imageRight;
    private Bitmap image;

    private static final float startHp = 100;
    private static final int startSpeed = 4;

    private int scores = 0;

    public Player(int x, int y) {
        super(x, y, startHp, Team.TeamOne);
        RocketGun weapon = new RocketGun(this);
        setWeapon(weapon);
        setDir(Direction.RIGHT);
        setSpeed(startSpeed);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        imageLeft = level.loadImage(R.drawable.player_left);
        imageRight = level.loadImage(R.drawable.player_right);
        image = imageRight;
    }

    public Bitmap getImage() {
        return image;
    }

    @Override
    public void tick() {
        if (!isLive()) {
            return;
        }

        if (level.canMove(getX() + dx, getY() + dy, getImageWidth(), getImageHeight())) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
        weapon.tick();
    }

    public void onSensorChanged(SensorEvent event) {
        float xy_angle = event.values[0];
        float xz_angle = event.values[1];
        float zy_angle = event.values[2];

        if (xy_angle < -1.5) {
            dy = -getSpeed();
        } else
        if (xy_angle > 1.5){
            dy = getSpeed();
        } else {
            dy = 0;
        }

        if (xz_angle < -1.5) {
            dx = -getSpeed();
            setDir(Direction.LEFT);
            image = imageLeft;
        } else
        if (xz_angle > 1.5) {
            dx = getSpeed();
            setDir(Direction.RIGHT);
            image = imageRight;
        } else {
            dx = 0;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            weapon.useWeapon();
        }
        return true;
    }

    public int getScores() {
        return scores;
    }

    public void addScores(int scores) {
        this.scores += scores;
    }
}
