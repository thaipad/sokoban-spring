/**********************************************************************
 * Старая добрая игра Сокобан. Писал в рамках обучения на JavaRush.
 * Отрефакторил с целью попрактиковаться в создании бинов Spring Framework
 * Использовал два метода: XML-описание и конфигурирование через классы
 */

package pro.thaipad.sokoban_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartGame {

    public static void main(String[] argv) {
        /***************************************************************
         * Создаю бины модели, представления и контроллера (переходника)
         * с помощью XML.
         * Бины объектов (ящики, стены, места и игрок) создаю с помощью
         * класса ConfigObjects и загружаю в классе LevelLoader
         * *************************************************************/

        ApplicationContext ctxMain = new ClassPathXmlApplicationContext("spring_main.xml");

    }

}
