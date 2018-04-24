package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.*;
import com.mygdx.managers.CrazyPuttingGame;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
//import com.mygdx.managers.CrazyPuttingGame;

public class GameScreenAuto extends InputAdapter implements Screen {

    CrazyPuttingGame game;
    ShapeRenderer renderer;
    ExtendViewport viewport;
    SpriteBatch batch;

    private PerspectiveCamera cam;
    private Model model;

    private ModelInstance instance;
    private ModelInstance ball;
    private ModelInstance start;
    private ModelInstance end;
    private ModelInstance water;
    private ModelInstance origin;

    private ModelBatch modelBatch;
    private Environment environment;
    private CameraInputController camController;
    private MeshPartBuilder meshPartBuilder;

    private boolean loaded = false;
    private boolean ready = false;

    private Texture powerBar;
    private float  power = 1;

    private TextureRegion textureRegion;
    private Texture arrow;
    private float arrowWidth = 200f;
    private float arrowHeigth = 100f;
    private float angle = 360;

    private int level;

    private Ball rollingBall;
    private Vector3 pos;

    private int state = 0;
    private float ep;

    private Map m;

    public GameScreenAuto(CrazyPuttingGame game, int level){
        this.game = game;
        this.powerBar = new Texture("core/assets/pwerBar.9.png");
        this.arrow = new Texture("core/assets/arrow.png");
        this.textureRegion = new TextureRegion(this.arrow);
        this.rollingBall = new Ball();
        this.level = level;
        createLevel(level);
    }

    @Override
    public void render (float delta) {
        if(loaded && ready) {


            if(rollingBall.isStationary() && state == 1) {
                System.out.println("stopped");
                Vector3 tmpPos = rollingBall.getPosition();
                if(m.getEndPos().dst(tmpPos.x, tmpPos.y) < ep*4) {
                    state = 2;
                    System.out.print("You Win");
                }
                rollingBall.resetVelocity();
                state = 0;
            }

            if(state == 1) {
                rollingBall.setNewPosition(m);
                pos = rollingBall.getNewPosition();

                if(pos.z < -0.1)
                    rollingBall.resetPosition();

                if(pos.x > 10 || pos.x < -10 || pos.y > 10 || pos.y < -10)
                    rollingBall.resetPosition();


                pos=rollingBall.getNewPosition();
                ball.transform.setTranslation(pos.x,  (float) Terrain.compute(level, pos.x, pos.y)/2 + 0.5f, pos.y);

                Vector3 tmpPos = rollingBall.getPosition();
                float mu = 0.3f;

                for(SandSpot s : m.getSandMap()) {
                    if(s.getPosition().dst(pos.x,pos.y) < ep*s.getRadius()) {
                        mu = 0.6f;
                    }
                }
                rollingBall.setNewVelocity(mu);
            }



            Gdx.gl.glClearColor(0f, 0.5f, 0.5f, 1f);
            Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);


            //cam.position.set(ball.nodes.get(0). .getX(), sprite.getY(), 0);
            camController.update();

            modelBatch.begin(cam);
            modelBatch.render(water,environment);
            modelBatch.render(instance, environment);
            modelBatch.render(ball, environment);
            modelBatch.render(start,environment);
            modelBatch.render(end,environment);
            modelBatch.render(origin,environment);
            modelBatch.end();


        } else if(!loaded) {
            loaded = true;
            createLevel(this.level);
            //loadLevel();
        }

        this.batch.begin();

        this.batch.draw(this.powerBar,Gdx.graphics.getWidth() - 100,0,100,Gdx.graphics.getHeight() * this.power);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(this.power <= 0.99f) {
                this.power = this.power + 0.01f;
                System.out.println("power = "+power);
            }
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(this.power >= 0.01f) {
                this.power = this.power - 0.01f;
                System.out.println("power = "+power);
            }
        }




        this.batch.draw(this.textureRegion,200,100,this.arrowWidth/2,this.arrowHeigth/2,200,100,1f,1f,this.angle);

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(this.angle >= 1) {
                this.angle = this.angle - 5;
                System.out.println("angle = " + angle);
                updateArrow();
            }
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(this.angle < 360) {
                this.angle = this.angle + 5;
                System.out.println("angle = " + angle);
                updateArrow();
            }
        }

        this.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.P)){
            game.showPauseScreen();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && this.state == 0){
            float prove = this.power * 10;
            float proveAngle = getRightAngle(this.angle);
            rollingBall.setVelocity(prove,fromDegreeToRadians(proveAngle));
            this.state = 1;
        }
    }

    private void updateArrow() {
        origin.transform.setToRotationRad(new Vector3(0,1,0), angle);
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
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}



    private void createLevel(int t) {

        this.m = MapFactory.createMap(t);
        rollingBall.setInitialPosition(m.getStartPos(), m);

        modelBatch = new ModelBatch();

        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.position.set(10f, 10f, 10f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(Color.WHITE, 0.2f, -1f, 0.2f));

        camController = new CameraInputController(cam);
        Gdx.input.setInputProcessor(camController);

        int scale = 4;
        float ep = 1/ (float)scale;
        int tot = scale * 20;

        int k = 2;

        ArrayList<Face> faces = new ArrayList<Face>();


        //adds the surface of the minigolf island

        Color toUse = Color.GREEN;

        for (float x = -10; x < 10; x += ep ) {
            for (float y = -10; y < 10; y+= ep) {
                int ax = (int) (x+10)*scale;
                int ay = (int) (y+10)*scale;

                toUse = Color.GREEN;

                for(SandSpot s : m.getSandMap()) {
                    if(s.getPosition().dst(x,y) < ep*s.getRadius()) {
                        toUse = Color.YELLOW;
                    }
                }

                faces.add(new Face(
                        new Vector3(x,    (float)Terrain.compute(t,x, y+ep)/k, y+ep),
                        new Vector3(x+ep, (float)Terrain.compute(t,x+ep, y)/k, y),
                        new Vector3(x,    (float)Terrain.compute(t,x,y)/k, y),
                        toUse));

                faces.add(new Face(
                        new Vector3(x+ep, (float)Terrain.compute(t,x+ep, y+ep)/k, y+ep),
                        new Vector3(x+ep, (float)Terrain.compute(t,x+ep,y)/k, y),
                        new Vector3(x,    (float)Terrain.compute(t,x,y+ep)/k, y+ep),
                        toUse));

            }
        }

        //adds the 'dirt' sides to the minigolf island

        for (float x = -10; x < 10; x += ep ) {
            faces.add( new Face(
                    new Vector3(x,    (float)Terrain.compute(t,x,   -10)/k, -10),
                    new Vector3(x+ep, (float)Terrain.compute(t,x+ep,-10)/k, -10),
                    new Vector3(x,    -10, -10),
                    Color.GRAY));

            faces.add(new Face(
                    new Vector3(x+ep,    (float)Terrain.compute(t,x+ep,   -10)/k, -10),
                    new Vector3(x+ep, -10, -10),
                    new Vector3(x, -10, -10),
                    Color.GRAY));
        }

        for (float x = -10; x < 10; x += ep ) {
            faces.add( new Face(
                    new Vector3(x,    (float)Terrain.compute(t,x,   10)/k, 10),
                    new Vector3(x, -10, 10),
                    new Vector3(x+ep,    (float)Terrain.compute(t,x+ep,10)/k, 10),
                    Color.GRAY));

            faces.add(new Face(
                    new Vector3(x+ep,    (float)Terrain.compute(t,x+ep,10)/k, 10),
                    new Vector3(x, -10, 10),
                    new Vector3(x+ep, -10, 10),
                    Color.GRAY));
        }

        for (float y = -10; y < 10; y += ep ) {
            faces.add( new Face(
                    new Vector3(-10,    (float)Terrain.compute(t,-10,   y)/k, y),
                    new Vector3(-10, -10, y),
                    new Vector3(-10,    (float)Terrain.compute(t,-10,y+ep)/k, y+ep),
                    Color.GRAY));

            faces.add(new Face(
                    new Vector3(-10,    (float)Terrain.compute(t,-10,y+ep)/k, y+ep),
                    new Vector3(-10, -10, y),
                    new Vector3(-10, -10, y+ep),
                    Color.GRAY));
        }

        for (float y = -10; y < 10; y += ep ) {
            faces.add( new Face(
                    new Vector3(10,    (float)Terrain.compute(t,10,   y)/k, y),
                    new Vector3(10, (float)Terrain.compute(t,10,y+ep)/k, y+ep),
                    new Vector3(10,  -10,   y),
                    Color.GRAY));

            faces.add(new Face(
                    new Vector3(10, (float)Terrain.compute(t,10,y+ep)/k, y+ep),
                    new Vector3(10, -10, y+ep),
                    new Vector3(10, -10, y),
                    Color.GRAY));
        }


        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();

        int attr = VertexAttributes.Usage.Position  | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates;

        for(Face face : faces) {

            modelBuilder.part(
                    "face"+face.getID(),
                    GL20.GL_TRIANGLES,
                    attr,
                    new Material( ColorAttribute.createDiffuse(face.getColor()))
            ).triangle(face.getA(), face.getB(), face.getC());

        }

        instance = new ModelInstance(modelBuilder.end(), 0, 0, 0);

        start = new ModelInstance(modelBuilder.createBox(0.3f, 0.1f, 0.3f,new Material(ColorAttribute.createDiffuse(Color.WHITE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));

        water = new ModelInstance(modelBuilder.createBox(19.9f, 10f, 19.9f, new Material(ColorAttribute.createDiffuse(Color.BLUE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));

        end = new ModelInstance(modelBuilder.createCylinder(0.1f, 4f, 0.1f, 10, new Material(ColorAttribute.createDiffuse(Color.WHITE)), attr));

        ball = new ModelInstance(modelBuilder.createSphere(1f, 1f, 1f, 20, 20, new Material(ColorAttribute.createDiffuse(Color.WHITE)), attr));

        origin = new ModelInstance(modelBuilder.createBox(2f, 0.1f, 0.1f,new Material(ColorAttribute.createDiffuse(Color.WHITE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));


        Vector2 s = m.getStartPos();
        Vector2 e = m.getEndPos();

        origin.transform.setTranslation(s.x - 2,  (float)Terrain.compute(t, s.x, s.y)/k + 1, s.y);

        start.transform.setTranslation(s.x,  (float)Terrain.compute(t, s.x, s.y)/k, s.y);
        end.transform.setTranslation(e.x,  (float)Terrain.compute(t, e.x, s.y)/k, e.y);
        ball.transform.setTranslation(s.x,  (float)Terrain.compute(t, s.x, s.y)/k + 0.5f, s.y);
        water.transform.setTranslation(0,-5f,0);

        //allow the level to be rendered
        ready = true;
    }

    public float fromDegreeToRadians(float degree){
        float radians =(float)((degree*Math.PI)/180);
        return radians;
    }

    //method to make some tests
    public float getRightAngle(float angle){
        float prove = angle;
        if(prove <= 180){
            prove = 270 - (angle - 270);
        }else{
            prove = 90 - (angle - 90);
        }
        return  prove;
    }

    public Map getMap(){
        return this.m;
    }
}
