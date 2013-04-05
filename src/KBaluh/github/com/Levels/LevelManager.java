package KBaluh.github.com.Levels;

import KBaluh.github.com.GameScreen;
import android.content.Context;

import java.util.ArrayList;

/**
 * Author: KBaluh
 * Date: 19.10.12:22:29
 */
public class LevelManager {

    private ArrayList<Level> levels = new ArrayList<Level>();

    private int index = 0;

    public LevelManager(GameScreen screen, Context context) {
        initLevels(screen, context);
    }

    public boolean isNext() {
        return (index + 1 < levels.size());
    }

    public Level next() {
        return levels.get(++index);
    }

    public Level first() {
        index = 0;
        return levels.get(0);
    }

    private void initLevels(GameScreen screen, Context context) {
        levels.clear();
        levels.add(new MainMenuLevel(context, screen));
        levels.add(new StartupLevel(context, screen));
    }
}
