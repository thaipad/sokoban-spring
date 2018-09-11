/*******************************************************
 * Реализация интерфейса View с помощью пакета Swing
 */

package pro.thaipad.sokoban_spring.view;

import javax.swing.*;
import pro.thaipad.sokoban_spring.controller.EventListener;
import pro.thaipad.sokoban_spring.model.Direction;
import pro.thaipad.sokoban_spring.gameobjects.GameObject;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class ViewImpl extends JFrame implements View {
    private EventListener eventListener; // bean Controller
    private Field field = new Field();

    public class Field extends JPanel {
        public void init() {
            addKeyListener(ViewImpl.this.getKeyHandler());
            setFocusable(true);
        }

        public void paint(Graphics g) {
            g.setColor(Color.lightGray);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
            for (GameObject obj : ViewImpl.this.getGameObjects()) {
                obj.draw(g);
            }

        }
    }

    @Override
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void setField(Field field) {
        this.field = field;
    }

    // init-method of bean
    public void init() {
        // injection of Field to here
        field.init();
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }

    // init or refresh?
    @Override
    public void update() {
        field.repaint();
    }

    public Set<GameObject> getGameObjects() {
        return eventListener.getGameObjects();
    }

    @Override
    public void completed(int level) {
        update();
        JOptionPane.showMessageDialog(null, "Вы прошли " + level + " уровень", "", JOptionPane.INFORMATION_MESSAGE);
        eventListener.startNextLevel();
    }

    public KeyAdapter getKeyHandler() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        eventListener.move(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        eventListener.move(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_UP:
                        eventListener.move(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        eventListener.move(Direction.DOWN);
                        break;
                    case KeyEvent.VK_R:
                        eventListener.restart();
                }
            }
        };
    }

}
