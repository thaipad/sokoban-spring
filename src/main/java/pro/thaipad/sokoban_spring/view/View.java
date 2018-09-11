/*******************************************************
 * GUI и управление игрой
 */

package pro.thaipad.sokoban_spring.view;

import pro.thaipad.sokoban_spring.controller.EventListener;

public interface View {
    void setEventListener(EventListener eventListener);
    void init();
    void update();
    void completed(int level);
}
