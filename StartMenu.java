package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.managers.CrazyPuttingGame;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StartMenu extends InputAdapter implements Screen{
	private CrazyPuttingGame game;
	private static OrthographicCamera cam;
	private FitViewport viewport;
	private ShapeRenderer renderer;
    public SpriteBatch batch = new SpriteBatch();
    public BitmapFont font = new BitmapFont();

    public StartMenu(CrazyPuttingGame game){
		this.game = game;
	}


	@Override
	public void render (float delta) {
		viewport.apply();
        Gdx.gl.glClearColor(.153f, .255f, .153f, 7);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "Welcome to Crazy Putting", 150, 400);

        batch.end();

	}


	@Override
	public void dispose () {

	}

	@Override
	public void show(){



		viewport = new FitViewport(GameConstants.MENU_WIDTH, GameConstants.MENU_HEIGTH);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

		if (worldTouch.x < 500 && worldTouch.y < 500) {
			System.out.println(worldTouch.x + " - " + worldTouch.y);
			game.showGameScreen();
		}
		return true;
	}


	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}
}

