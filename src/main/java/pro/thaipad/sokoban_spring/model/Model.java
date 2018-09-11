/********************************************************
 * Модель игры, для управления и отображения используется
 * интерфейс EventListener
 */

package pro.thaipad.sokoban_spring.model;

import pro.thaipad.sokoban_spring.controller.EventListener;
import pro.thaipad.sokoban_spring.gameobjects.GameObject;

import java.util.Set;

public interface Model {
    void setEventListener(EventListener eventListener);
    void move(Direction direction);
    void restartCurrentLevel();
    void startNextLevel();
    Set<GameObject> getGameObjects();
}
