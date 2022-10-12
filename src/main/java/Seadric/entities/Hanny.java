package Seadric.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import Seadric.Waterworld;
import Seadric.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    private HealthText healthText;
    private Waterworld waterworld;
    private int health = 3;

    public Hanny(Coordinate2D location, HealthText healthText, Waterworld waterworld){
        super("sprites/hanny.png", location, new Size(60,80), 1, 2);
        this.waterworld = waterworld;
        this.healthText = healthText;
        healthText.setHealthText(health);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.A)){
            setMotion(3,270d);
            setCurrentFrameIndex(2);
        } else if(pressedKeys.contains(KeyCode.D)){
            setMotion(3,90d);
            setCurrentFrameIndex(2);
        } else if(pressedKeys.contains(KeyCode.W)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.S)){
            setMotion(3,0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() -1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        setAnchorLocation( new Coordinate2D(
                new Random().nextInt((int)(getSceneWidth()-getWidth())),
                new Random().nextInt((int)(getSceneHeight()-getHeight())))
        );
        health--;
        healthText.setHealthText(health);
        if(health == 0) {
            waterworld.setActiveScene(2);
        }

    }
}
