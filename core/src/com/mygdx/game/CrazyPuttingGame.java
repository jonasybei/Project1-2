package com.mygdx.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.screen.*;

public class CrazyPuttingGame extends Game {

    private GameScreen game;

    public int height = 900;
    public int width = 1500;

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

    public void showUser1Screen() {
        setScreen(new User1Screen(this));
    }

    public void showLevelScreen(){
        setScreen(new LevelScreen(this));
    }

    public void showNameScreen(){
        setScreen(new InsertNameScreen(this));
    }

    public void showWinScreen(int score){
        setScreen(new WinScreen(this, score));
    }

    public void showLevelScreenAuto(){
        setScreen(new LevelScreenAuto(this));
    }

    public void showPauseScreen(){
        setScreen(new PauseScreen(this));
    }

    public void showGameScreenAuto(int level){
        setScreen(new GameScreenAuto(this,level));
    }

    public void resumeGameScreen(){
        setScreen(this.game);
    }

    public void exitTheGame(){
        Gdx.app.exit();
    }


}
