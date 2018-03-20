package com.mygdx.managers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameScreen;
import com.mygdx.game.StartMenu;

public class CrazyPuttingGame extends Game{

    @Override
    public void create() {
        showMenuScreen();
    }

    public void showMenuScreen() {
        setScreen(new StartMenu(this));
    }

    public void showGameScreen() {
        System.out.println("Changing screen");
        setScreen(new GameScreen(this));
    }

    public void exitTheGame(){
        System.out.println("exit");
    }


}
