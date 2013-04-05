package KBaluh.github.com.Entity.SupportItems;

import KBaluh.github.com.R;
import android.graphics.Bitmap;

/**
 * User: KBaluh
 * Date time: 17.10.12 14:56
 */
public class MedicineChest extends SupportItem {

    private Bitmap image;

    private static int speed = 3;

    private static int bonus = 35;

    public MedicineChest(int x, int y) {
        super(x, y, speed, bonus);
    }

    @Override
    public void afterInit() {
        if (level == null) {
            return;
        }

        image = level.loadImage(R.drawable.medicine_chest);
    }

    public Bitmap getImage() {
        return image;
    }
}
