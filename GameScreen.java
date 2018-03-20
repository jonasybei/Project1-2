package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.managers.CrazyPuttingGame;

public class GameScreen extends InputAdapter implements Screen{

    CrazyPuttingGame game;
    ShapeRenderer renderer;
    ExtendViewport viewport;
    SpriteBatch batch;


    public GameScreen(CrazyPuttingGame game){
        this.game = game;
    }


    @Override
    public void render (float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(1f, .100f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void dispose () {

    }

    @Override
    public void show(){
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();

        viewport = new ExtendViewport(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGTH);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}
}
