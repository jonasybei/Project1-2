package com.mygdx.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.*;

public class CrazyPuttingGame extends Game{

    @Override
    public void create() {
        showMenuScreen();
    }

    public void showMenuScreen() {
        setScreen(new StartMenu(this));
    }

    public void showGameScreen(int level) {
        setScreen(new GameScreen(this , level));
    }

    public void showModeScreen() {
        setScreen(new ModeScreen(this));
    }

    public void showScoreScreen() {
        setScreen(new ScoreScreen(this));
    }

    public void showLevelScreen(){
        setScreen(new LevelScreen(this));
    }

    public void exitTheGame(){
        Gdx.app.exit();
    }


}
