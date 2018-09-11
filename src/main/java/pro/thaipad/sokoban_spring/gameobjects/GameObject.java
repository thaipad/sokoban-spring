/*********************************************
 * Базовый класс игрового объекта, реализует
 * работу с координатами и описывает метод
 * отрисовки draw
 */

package pro.thaipad.sokoban_spring.gameobjects;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public abstract class GameObject {
    private int x, y;
    private int width, height;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = FIELD_CELL_SIZE;
        this.height = FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void draw(Graphics graphics) ;
}
