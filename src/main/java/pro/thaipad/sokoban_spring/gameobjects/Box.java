package pro.thaipad.sokoban_spring.gameobjects;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        int x1 = getX() - FIELD_CELL_SIZE / 2 + 1;
        int y1 = getY() - FIELD_CELL_SIZE / 2 + 1;
        int size = FIELD_CELL_SIZE - 3;
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(x1, y1, size, size);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x1, y1, size, size);
        graphics.drawLine(x1, y1, x1 + size, y1 + size);
        graphics.drawLine(x1, y1 + size, x1 + size, y1);
    }
}
