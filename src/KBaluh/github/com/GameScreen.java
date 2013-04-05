package KBaluh.github.com;

import KBaluh.github.com.Levels.Level;
import KBaluh.github.com.Levels.LevelManager;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * User: KBaluh
 * Date time: 16.10.12 17:21
 */
public class GameScreen extends SurfaceView implements SensorEventListener {

    /**
     * Объект класса GameLoopThread
     */
    private GameThread mThread;

    Canvas canvas;

    /**
     * Переменная запускающая поток рисования
     */
    private boolean running = true;

    private LevelManager levelManager;
    private Level level;

    public GameScreen(Context context) {
        super(context);

        mThread = new GameThread(this);

        //Рисуем все наши объекты
        getHolder().addCallback(new SurfaceHolder.Callback() {
            /*** Уничтожение области рисования */
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                mThread.setRunning(false);
                while (retry) {
                    try {
                        // ожидание завершение потока
                        mThread.join();
                        retry = false;
                    } catch (InterruptedException e) {
                    }
                }
            }

            /** Создание области рисования */
            public void surfaceCreated(SurfaceHolder holder) {
                mThread.setRunning(true);
                mThread.start();
            }

            /** Изменение области рисования */
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });

        levelManager = new LevelManager(this, context);
        level = levelManager.first();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        level.paint(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return level.onTouchEvent(e);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        level.onSensorChanged(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        level.onAccuracyChanged(sensor, accuracy);
    }

    public class GameThread extends Thread {

        /**
         * Объект класса
         */
        private GameScreen view;

        /**
         * Конструктор класса
         */
        public GameThread(GameScreen view) {
            this.view = view;
        }

        /**
         * Задание состояния потока
         */
        public void setRunning(boolean run) {
            running = run;
        }

        /**
         * Действия, выполняемые в потоке
         */
        @Override
        public void run() {
            while (running) {
                try {
                    // подготовка Canvas-а
                    canvas = view.getHolder().lockCanvas();
                    synchronized (view.getHolder()) {
                        level.tick();
                        onDraw(canvas);
                        if (level.levelIsDone()) {
                            level.levelStop();
                            if (levelManager.isNext()) {
                                level = levelManager.next();
                            } else {
                                running = false;
                                System.exit(1);
                            }
                        }
                    }
                } catch (Exception e) {
                } finally {
                    if (canvas != null) {
                        view.getHolder().unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
