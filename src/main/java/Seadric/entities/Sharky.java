package Seadric.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import Seadric.Waterworld;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {
    Waterworld waterworld;
    public Sharky(Coordinate2D initialLocation, Waterworld waterworld) {
        super("sprites/sharky.png", initialLocation, new Size(200,100), 1, 2);
        this.waterworld = waterworld;
        setMotion(2, 270d);
    }

    @Override
    protected void setAutoCycle(long interval) {
        super.setAutoCycle(interval);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()-71));
    }
}
