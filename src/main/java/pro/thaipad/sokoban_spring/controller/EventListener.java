/*********************************************
 * Не контроллер в чистом виде из паттерна MCV,
 * больше походит на адаптер между View (JFrame)
 * и Model
 */

package pro.thaipad.sokoban_spring.controller;

import pro.thaipad.sokoban_spring.model.Direction;
import pro.thaipad.sokoban_spring.gameobjects.GameObject;

import java.util.Set;

public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void completed(int level);
    Set<GameObject> getGameObjects();
}
