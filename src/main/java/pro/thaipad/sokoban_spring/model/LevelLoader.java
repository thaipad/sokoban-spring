package pro.thaipad.sokoban_spring.model;

import org.springframework.context.ApplicationContext;
import pro.thaipad.sokoban_spring.gameobjects.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static pro.thaipad.sokoban_spring.model.ModelImpl.FIELD_CELL_SIZE;

public class LevelLoader {
    private File levels;
    private ApplicationContext ctxObjects;

    public LevelLoader(ApplicationContext ctxObjects) {
        this.levels = new File(getClass().getClassLoader().getResource("levels.txt").getFile());
        this.ctxObjects = ctxObjects;
    }

    public GameObjects getLevel(int level) {
        try (BufferedReader reader = new BufferedReader(new FileReader(levels))) {
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Set<Wall> walls = new HashSet<>();
            Player player = null;
            String line;
            if (level < 1) {
                level = 1;
            }
            level = (level - 1) % 60 + 1;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Maze: " + Integer.toString(level))) {
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    reader.readLine();
                    int y = FIELD_CELL_SIZE / 2;
                    while (!(line = reader.readLine()).equals("")) {
                        for (int i = 0; i < line.length(); ++i) {
                            int x = FIELD_CELL_SIZE / 2 + i * FIELD_CELL_SIZE;
                            switch (line.charAt(i)) {
                                case 'X':
//                                    walls.add(new Wall(x, y));
                                    walls.add(ctxObjects.getBean(Wall.class, x, y));
                                    break;
                                case '*':
                                    boxes.add(ctxObjects.getBean(Box.class, x, y));
                                    break;
                                case '.':
                                    homes.add(ctxObjects.getBean(Home.class, x, y));
                                    break;
                                case '&':
                                    boxes.add(ctxObjects.getBean(Box.class, x, y));
                                    homes.add(ctxObjects.getBean(Home.class, x, y));
                                    break;
                                case '@':
                                    player = ctxObjects.getBean(Player.class, x, y);
                            }

                        }
                        y += FIELD_CELL_SIZE;
                    }
                    break;
                }
            }
            return new GameObjects(walls, boxes, homes, player);
        }
        catch (IOException e) {
            return null;
        }

    }
}
