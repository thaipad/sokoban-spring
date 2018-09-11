/**************************************************
 * интерфейс для движущихся объектов (игрок, ящики)
 */

package pro.thaipad.sokoban_spring.gameobjects;

public interface Movable {
    void move(int x, int y);
}
