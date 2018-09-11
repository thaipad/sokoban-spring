package pro.thaipad.sokoban_spring.gameobjects;

import java.awt.*;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y, 1, 1);
    }

    @Override
    public void draw(Graphics graphics) {
        int x1 = getX() - FIELD_CELL_SIZE / 2;
        int y1 = getY() - FIELD_CELL_SIZE / 2;
        int size = FIELD_CELL_SIZE;
        graphics.setColor(Color.RED );
        graphics.drawRect(x1, y1, size, size);

    }
}
