package com.mygdx.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.*;

public class CrazyPuttingGame extends Game{

    private GameScreen game;

    @Override
    public void create() {
        showMenuScreen();
    }

    public void showMenuScreen() {
        setScreen(new StartMenu(this));
    }

    public void showGameScreen(int level) {
        this.game = new GameScreen(this,level);
        setScreen(this.game);
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

    public void showPauseScreen(){
        setScreen(new PauseScreen(this));
    }

    public void resumeGameScreen(){
        setScreen(this.game);
    }

    public void exitTheGame(){
        Gdx.app.exit();
    }


}
