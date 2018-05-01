package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;


public class StartMenu extends GolfScreen {

    private TextButton playButton;
    private TextButton scoreButton;
    private TextButton exitButton;

    public StartMenu(CrazyPuttingGame game){
        super(game);
    }

	@Override
	public void show() {
        super.show();

        this.playButton = new TextButton("PLAY" , textButtonStyle);
        this.playButton.pad(20);
        this.playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showModeScreen();
                
            }
        });

        this.scoreButton = new TextButton("SCORES" , textButtonStyle);
        this.scoreButton.pad(20);
        this.scoreButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showScoreScreen();
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
        this.heading = new Label("CRAZY PUTTING" , headingStyle);
        this.heading.setFontScale(2);


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

