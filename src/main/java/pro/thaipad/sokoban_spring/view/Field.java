package pro.thaipad.sokoban_spring.view;

import javax.swing.*;
import java.awt.*;
import pro.thaipad.sokoban_spring.gameobjects.GameObject;

import java.util.Set;

public class Field extends JPanel {
    private ViewImpl view; // bean ViewImpl

    public Field(ViewImpl view) {
        this.view = view;
    }

    public void init() {
        addKeyListener(view.getKeyHandler());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        Set<GameObject> objects = view.getGameObjects();
        for (GameObject obj : objects) {
            obj.draw(g);
        }

    }
}
