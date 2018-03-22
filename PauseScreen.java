package com.mygdx.game;

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


public class PauseScreen extends InputAdapter implements Screen{
    private CrazyPuttingGame game;
    private FitViewport viewport;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton playButton;
    private TextButton scoreButton;
    private TextButton exitButton;
    private BitmapFont font;
    private BitmapFont headingFont;
    private Label heading;


    public PauseScreen(CrazyPuttingGame game){
        this.game = game;
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.act(delta);
        this.stage.draw();
    }

    @Override
    public void show(){
        this.stage = new Stage();
        this.atlas = new TextureAtlas("C:\\Users\\matte.LAPTOP-FLG8V3QC\\Documents\\UM\\PROJECTS\\Project.Putting\\core\\assets\\button.pack");
        this.skin = new Skin(atlas);
        this.table = new Table(skin);
        this.font = new BitmapFont();
        this.headingFont = new BitmapFont();
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = this.font;
        textButtonStyle.fontColor = Color.BLACK;

        this.playButton = new TextButton("RESUME" , textButtonStyle);
        this.playButton.pad(20);
        this.playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.resumeGameScreen();;

            }
        });


        this.exitButton = new TextButton("EXIT THE GAME" , textButtonStyle);
        this.exitButton.pad(20);
        this.exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("PAUSE" , headingStyle);
        this.heading.setFontScale(4);



        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(100);
        this.table.row();
        this.table.add(this.playButton);
        this.table.getCell(this.playButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.scoreButton);
        this.table.getCell(this.scoreButton).spaceBottom(50);
        this.table.row();
        this.table.add(this.exitButton);
        this.table.debug();
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


