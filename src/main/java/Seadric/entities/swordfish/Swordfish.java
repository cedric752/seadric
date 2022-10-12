package Seadric.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider {
    public Swordfish(Coordinate2D location){
        super(location);
        setMotion(2, 270d);
    }

    @Override
    protected void setupEntities() {
        var Hitbox = new HitBox(new Coordinate2D(0 , 0));
        Hitbox.setFill(Color.PURPLE);
        var swordf = new SwordfishSprite(new Coordinate2D(0 , 0));
        addEntity(Hitbox);
        addEntity(swordf);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()-71));
    }
}
