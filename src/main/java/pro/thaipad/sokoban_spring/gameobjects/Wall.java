package pro.thaipad.sokoban_spring.gameobjects;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int x1 = getX() - FIELD_CELL_SIZE / 2;
        int y1 = getY() - FIELD_CELL_SIZE / 2;
        int size = FIELD_CELL_SIZE;
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x1, y1, size, size);
    }
}
