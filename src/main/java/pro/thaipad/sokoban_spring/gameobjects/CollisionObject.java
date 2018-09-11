/******************************************************
 * Базовый класс для объектов, которые взаимодействуют
 * друг с другом (собственно, всех, кроме мест для ящиков)
 */

package pro.thaipad.sokoban_spring.gameobjects;

import pro.thaipad.sokoban_spring.model.Direction;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y, 1, 1);
    }

    @Override
    public void draw(Graphics graphics) {

    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int newX = getX();
        int newY = getY();
        switch (direction) {
            case UP:
                newY -= FIELD_CELL_SIZE;
                break;
            case DOWN:
                newY += FIELD_CELL_SIZE;
                break;
            case LEFT:
                newX -= FIELD_CELL_SIZE;
                break;
            case RIGHT:
                newX += FIELD_CELL_SIZE;
        }
        if (newX == gameObject.getX() && newY == gameObject.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
