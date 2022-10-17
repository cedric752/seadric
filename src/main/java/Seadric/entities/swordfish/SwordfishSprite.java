package Seadric.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SwordfishSprite extends SpriteEntity {

    public SwordfishSprite(final Coordinate2D location) {
        super("sprites/swordfish.png", location);
    }
    protected SwordfishSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
