package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;


public class PauseScreen extends GolfScreen{
    private TextButton playButton;
    private TextButton scoreButton; //Never Assigned, but is used line ~60
    private TextButton exitButton;


    public PauseScreen(CrazyPuttingGame game){
        super(game);
    }

    @Override
    public void show() {
        super.show();

        this.playButton = new TextButton("LEVELS" , textButtonStyle);
        this.playButton.pad(20);
        this.playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showLevelScreen();

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
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }
}


