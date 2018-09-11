package pro.thaipad.sokoban_spring.gameobjects;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int x1 = getX() - FIELD_CELL_SIZE / 2 + 1;
        int y1 = getY() - FIELD_CELL_SIZE / 2 + 1;
        int size = FIELD_CELL_SIZE - 2;
        graphics.setColor(Color.BLUE);
        graphics.fillOval(x1, y1, size,size);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
