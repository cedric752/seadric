package Seadric;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import Seadric.entities.buttons.Gameover;
import Seadric.entities.buttons.PlayAgain;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends DynamicScene {
    private Waterworld waterworld;

    public GameOver(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
        setBackgroundAudio("audio/ocean.mp3");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.DARKBLUE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        var playAgain = new PlayAgain(new Coordinate2D(getWidth() / 2, getHeight() / 2), waterworld);
        playAgain.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var quitGame = new Gameover(new Coordinate2D(getWidth(), getHeight()), waterworld);
        quitGame.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);

        addEntity(gameOverText);
        addEntity(playAgain);
        addEntity(quitGame);
    }
}
