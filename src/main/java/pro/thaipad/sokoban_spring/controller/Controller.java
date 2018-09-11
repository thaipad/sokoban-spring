package pro.thaipad.sokoban_spring.controller;

import pro.thaipad.sokoban_spring.model.Direction;
import pro.thaipad.sokoban_spring.gameobjects.GameObject;
import pro.thaipad.sokoban_spring.model.Model;
import pro.thaipad.sokoban_spring.model.ModelImpl;
import pro.thaipad.sokoban_spring.view.View;
import pro.thaipad.sokoban_spring.view.ViewImpl;

import java.util.Set;

public class Controller implements EventListener{
    private View view;
    private Model model;

    public void setView(View view) {
        this.view = view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restartCurrentLevel();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public Set<GameObject> getGameObjects() {
        return model.getGameObjects();
    }

    @Override
    public void completed(int level) {
        view.completed(level);
    }
}
