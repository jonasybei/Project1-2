package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;



public class User1Screen extends GolfScreen {
    private TextButton user1Button;
    private TextButton user2Button;
    private TextButton user3Button;
    private TextButton backButton;
    private Label name;
    private Label level;
    private Label score;


    public User1Screen(CrazyPuttingGame game){
        super(game);
    }

    @Override
    public void show(){
        super.show();

        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showMenuScreen();
            }
        });




        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("USER1" , headingStyle);
        this.heading.setFontScale(2);


        this.name = new Label("USERNAME: " , headingStyle);
        this.name.setFontScale(2);


        this.level = new Label("LEVEL: " , headingStyle);
        this.level.setFontScale(2);


        this.score = new Label("SCORE: " , headingStyle);
        this.score.setFontScale(2);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(50);
        this.table.row();
        this.table.add(name);
        this.table.getCell(this.name).spaceBottom(20);
        this.table.row();
        this.table.add(level);
        this.table.getCell(this.level).spaceBottom(20);
        this.table.row();
        this.table.add(score);
        this.table.getCell(this.score).spaceBottom(20);
        this.table.row();
        this.table.add(this.backButton);
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }


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

