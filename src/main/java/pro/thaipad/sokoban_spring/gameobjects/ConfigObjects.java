/**********************************************
 * Создание бинов игровых объектов, соответствующий
 * контекст создаю в классе LevelLoader
 */

package pro.thaipad.sokoban_spring.gameobjects;

import org.springframework.context.annotation.*;

@ComponentScan("pro.thaipad.sokoban_spring")
@Configuration
public class ConfigObjects {

    @Bean
    @Scope("prototype")
    public Box box(int x, int y) {
        return new Box(x, y);
    }

    @Bean
    @Scope("prototype")
    public Wall wall(int x, int y) {
        return new Wall(x, y);
    }

    @Bean
    @Scope("prototype")
    public Player player(int x, int y) {
        return new Player(x, y);
    }

    @Bean
    @Scope("prototype")
    public Home home(int x, int y) {
        return new Home(x, y);
    }
}
