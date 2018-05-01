package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.managers.CrazyPuttingGame;


public class LevelScreen extends GolfScreen {

    private TextButton level1Button;
    private TextButton level2Button;
    private TextButton level3Button;
    private TextButton level4Button;
    private TextButton level5Button;
    private TextButton level6Button;
    private TextButton backButton;


    public LevelScreen(CrazyPuttingGame game){
        super(game);
    }


    @Override
    public void show(){
        super.show();


        this.level1Button = new TextButton("LEVEL 1" , textButtonStyle);
        this.level1Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(1);
            }
        });
        this.level1Button.pad(20);

        this.level2Button = new TextButton("LEVEL 2" , textButtonStyle);
        this.level2Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(2);
            }
        });
        this.level2Button.pad(20);

        this.level3Button = new TextButton("LEVEL 3" , textButtonStyle);
        this.level3Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(3);
            }
        });
        this.level3Button.pad(20);

        this.level4Button = new TextButton("LEVEL 4" , textButtonStyle);
        this.level4Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(4);
            }
        });
        this.level4Button.pad(20);

        this.level5Button = new TextButton("LEVEL 5" , textButtonStyle);
        this.level5Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(5);
            }
        });
        this.level5Button.pad(20);

        this.level6Button = new TextButton("LEVEL 6" , textButtonStyle);
        this.level6Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x,float y){
                game.showGameScreen(6);
            }
        });
        this.level6Button.pad(20);


        this.backButton = new TextButton("BACK" , textButtonStyle);
        this.backButton.pad(20);
        this.backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event ,float x,float y) {
                game.showModeScreen();
            }
        });


        LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
        this.heading = new Label("LEVELS" , headingStyle);
        this.heading.setFontScale(2);


        this.table.add(heading);
        this.table.getCell(this.heading).spaceBottom(50);
        this.table.row();
        this.table.add(this.level1Button);
        this.table.getCell(this.level1Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level2Button);
        this.table.getCell(this.level2Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level3Button);
        this.table.getCell(this.level3Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level4Button);
        this.table.getCell(this.level4Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level5Button);
        this.table.getCell(this.level5Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.level6Button);
        this.table.getCell(this.level6Button).spaceBottom(50);
        this.table.row();
        this.table.add(this.backButton);
        this.stage.addActor(this.table);
        Gdx.input.setInputProcessor(stage);
    }
}


