package com.mygdx.game.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.managers.CrazyPuttingGame;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;


public class WinScreen extends InputAdapter implements Screen{
    private CrazyPuttingGame game;
    private FitViewport viewport;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton menuButton;
    private TextButton levelButton;
    private TextButton exitButton;
    private BitmapFont font;
    private BitmapFont headingFont;
    private Label heading;
    private Label scoreText;
    private int score;
    private Texture background;

    public WinScreen(CrazyPuttingGame game , int score){
        this.score = score;
        this.game = game;
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background = new Texture("core/assets/golf.9.png");

        this.stage.act(delta);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, 1500, 900);
        stage.getBatch().end();
        this.stage.draw();
    }

    @Override
    public void show(){
        this.stage = new Stage();
        this.atlas = new TextureAtlas("core/assets/button.pack");
        this.skin = new Skin(atlas);
        this.table = new Table(skin);
        this.font = new BitmapFont();
        this.headingFont = new BitmapFont(Gdx.files.internal("core/assets/fonts/font.fnt"));
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = this.font;
        textButtonStyle.fontColor = Color.BLACK;

        this.menuButton = new TextButton("MENU" , textButtonStyle);
        this.menuButton.pad(20);
        this.menuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();

            }
        });

        this.levelButton = new TextButton("LEVELS" , textButtonStyle);
        this.levelButton.pad(20);
        this.levelButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showLevelScreen();
            }
        });

        this.exitButton = new TextButton("EXIT" , textButtonStyle);
        this.exitButton.pad(20);
        this.exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.exitTheGame();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("WELL DONE " , headingStyle);
        this.heading.setFontScale(2);
        String text = "YOU SCORED " + this.score;
        this.scoreText = new Label(text, headingStyle);
        this.scoreText.setFontScale(2);



        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(20);
        this.table.row();
        this.table.add(scoreText);
        this.table.getCell(this.scoreText).spaceBottom(70);
        this.table.row();
        this.table.add(this.menuButton);
        this.table.getCell(this.menuButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.levelButton);
        this.table.getCell(this.levelButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.exitButton);
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true; }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose () {}

    @Override
    public void resize(int width, int height) {}
}

