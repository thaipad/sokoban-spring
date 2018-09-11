package pro.thaipad.sokoban_spring.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.thaipad.sokoban_spring.controller.EventListener;
import pro.thaipad.sokoban_spring.gameobjects.*;

import java.util.HashSet;
import java.util.Set;

public class ModelImpl implements Model {
    public final static int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;

    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new AnnotationConfigApplicationContext(ConfigObjects.class));

    @Override
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public Set<GameObject> getGameObjects() {
        if (gameObjects != null) {
            return gameObjects.getAll();
        } else {
            return new HashSet<GameObject>();
        }
    }

    @Override
    public void restartCurrentLevel() {
        restartLevel(currentLevel);
    }

    @Override
    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    @Override
    public void move(Direction direction) {
        if (checkWallCollision(gameObjects.getPlayer(), direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        }
        gameObjects.getPlayer().move(getDeltaX(direction), getDeltaY(direction));
        checkCompletion();
    }

    private void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    private boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    private int getDeltaX(Direction direction) {
        if (direction == Direction.LEFT) {
            return -FIELD_CELL_SIZE;
        } else if (direction == Direction.RIGHT) {
            return FIELD_CELL_SIZE;
        } else {
            return 0;
        }
    }

    private int getDeltaY(Direction direction) {
        if (direction == Direction.UP) {
            return -FIELD_CELL_SIZE;
        } else if (direction == Direction.DOWN) {
            return FIELD_CELL_SIZE;
        } else {
            return 0;
        }
    }

    private boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box nextBox : gameObjects.getBoxes()) {
                    if (!nextBox.equals(box) && box.isCollision(nextBox, direction)) {
                        return true;
                    }
                }
                if (checkWallCollision(box, direction)) {
                    return true;
                }
                box.move(getDeltaX(direction), getDeltaY(direction));
            }
        }
        return false;
    }

    private void checkCompletion() {
        boolean levelCompleted = true;
        for (Home home : gameObjects.getHomes()) {
            boolean hasOwnBox = false;
            for (Box box : gameObjects.getBoxes()) {
                if (box.getX() == home.getX() && box.getY() == home.getY()) {
                    hasOwnBox = true;
                    break;
                }
            }
            if (!hasOwnBox) {
                levelCompleted = false;
                break;
            }
        }
        if (levelCompleted) {
            eventListener.completed(currentLevel);
        }
    }

}
