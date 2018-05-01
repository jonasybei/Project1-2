package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Random;


public class Test extends ApplicationAdapter {
	private PerspectiveCamera cam;
	private Model model;
	private ModelInstance instance;
	private ModelBatch modelBatch;
	private Environment environment;
	private CameraInputController camController;
	private MeshPartBuilder meshPartBuilder;

	
	@Override
	public void create () {
		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);

		int s = 5;

		int[] grid = {s,s};

		ArrayList<Face> faces = new ArrayList<>(2*(grid[0])*(grid[1]));

		for (int x = -grid[0]/2; x < grid[0]/2; x++) {
			for (int y = -grid[1]/2; y < grid[1]/2; y++) {
				faces.add( new Face(new Vector3(x,hF(x,y+1),y+1),   new Vector3(x+1,hF(x+1,y),y), new Vector3(x,hF(x,y),y),   Color.GREEN));
				faces.add( new Face(new Vector3(x+1,hF(x+1,y+1),y+1), new Vector3(x+1,hF(x+1,y),y), new Vector3(x,hF(x,y+1),y+1), new Color(0,0.6f,0,1)));
			}
		}

        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();

        int attr = Usage.Position  | Usage.Normal | Usage.TextureCoordinates;

        for(Face face : faces) {

            modelBuilder.part(
            		"face"+face.getID(),
					GL20.GL_TRIANGLES,
					attr,
                    new Material( ColorAttribute.createDiffuse(face.getColor()))
			).triangle(face.getA(), face.getB(), face.getC());

        }

		//triangle(face.getP1(), face.getP2(), face.getP3() );

        instance = new ModelInstance(modelBuilder.end(), 0, 0, 0);
	}

	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		camController.update();
		modelBatch.begin(cam);
		modelBatch.render(instance, environment);
		modelBatch.end();
	}
	
	@Override
	public void dispose () {
		modelBatch.dispose();
		//model.dispose();
	}


	//e^x-e^y-e^(-x^2-y^2)*10^4

	private float hF(float x, float y) {
		float r = (float) (Math.pow(x,2) + Math.pow(y,2))/40;
		if (r > 5) r = 5;
		return r;
	}
}
