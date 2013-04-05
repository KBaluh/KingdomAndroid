package KBaluh.github.com.Entity.Mobs;

import KBaluh.github.com.Entity.Direction;
import KBaluh.github.com.Entity.Team;
import KBaluh.github.com.R;
import android.graphics.Bitmap;

public class TopFish extends Mob {

    private Bitmap image;

    public TopFish(int x, int y) {
        super(x, y, 1, Team.TeamTwo);
        setDir(Direction.LEFT);
        setSpeed(4);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        image = level.loadImage(R.drawable.top_fish);
    }

    @Override
    public void tick() {
        super.tick();

    }

    @Override
    public Bitmap getImage() {
        return image;
    }

    @Override
    public int getScores() {
        return 10;
    }
}
