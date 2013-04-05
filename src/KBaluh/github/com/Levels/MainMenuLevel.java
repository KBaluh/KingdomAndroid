package KBaluh.github.com.Levels;

import KBaluh.github.com.Entity.Mobs.Player;
import KBaluh.github.com.Entity.Spawners.BubbleSpawner;
import KBaluh.github.com.GameScreen;
import KBaluh.github.com.Rectangle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

public class MainMenuLevel extends StartupLevel {

    private boolean isClickPlayButton;

    public MainMenuLevel(Context context, GameScreen gameScreen) {
        super(context, gameScreen);
    }

    @Override
    protected void initSpawners() {
        addSpawner(new BubbleSpawner());
    }

    @Override
    public boolean levelIsDone() {
        return isClickPlayButton;
    }

    @Override
    protected void initPlayer() {
        super.initPlayer();
    }

    @Override
    public void paint(Canvas g) {
        super.paint(g);
        Paint textPaint = new Paint();
        textPaint.setColor(Color.YELLOW);
        textPaint.setTextSize(18);
        int x = getPlayerX() + 5;
        int y = getPlayerY() - 10;
        g.drawText("Click to play", x, y, textPaint);
    }

    @Override
    protected void paintPanel(Canvas g) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            float x = e.getX();
            float y = e.getY();

            Player player = getPlayer();
            int w = getPlayerWidth();
            int h = getPlayerHeight();

            Rectangle clickRectangle = new Rectangle((int) x, (int) y, w, h);
            if (player.haveCollision(clickRectangle)) {
                isClickPlayButton = true;
            }
        }
        return true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    }

    @Override
    protected void showBattleText() {
    }
}
