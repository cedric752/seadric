package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene {
    private Waterworld waterworld;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var swordfish = new Swordfish(
                new Coordinate2D(getWidth() / 2, getHeight() / 2)
        );

        var healthText = new HealthText( new Coordinate2D(0 , 0));

        var hanny = new Hanny(
                new Coordinate2D(getWidth() / 4, getHeight() / 4),
                healthText, waterworld
        );

        var shark = new Sharky(new Coordinate2D(getWidth() / 4, getHeight() / 4),
                 waterworld);


        addEntity(swordfish);
        addEntity(hanny);
        addEntity(healthText);
        addEntity(shark);
    }
}
