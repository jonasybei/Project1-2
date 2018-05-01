package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;


public class WinScreen extends GolfScreen {
    private final int score;
    private TextButton menuButton;
    private TextButton levelButton;
    private TextButton exitButton;
    private Label scoreText;

    public WinScreen(CrazyPuttingGame game , int score){
        super(game);
        this.score = score;
    }

    @Override
    public void show(){
        super.show();

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
}

