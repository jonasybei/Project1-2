package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.lang.Math.*;

//This class computes the terrain with the use of functions. Those can be found here:
//https://docs.google.com/document/d/1ZUv9NAnBHs384mxa-9tkk39cExyGSKAK1exx1yJGvn0/edit?usp=sharing
//All terrains are meant to have a range of -10 to 10 for x, y, and z!

public class Terrain {

	public static Double compute(int terrain, double x, double y) {
		if (terrain == 1) {
			//(e^x-e^y)/2000-5*e^(-(x+5)^2-(y+2)^2)
			return ((Math.exp(x) - Math.exp(y))/2000 - 5*Math.exp(-Math.pow((x+5), 2) - Math.pow((y+2), 2)));
		} else if(terrain == 2) {
			//(x^2+y^3)/100 + 6*e^(-x^2-y^2)
			return ((Math.pow(x, 2) + Math.pow(y, 3))/100 + 6*Math.exp(-Math.pow(x, 2)-Math.pow(y, 2)));
		} else if(terrain == 3) {
			//abs(-x^3-y^3+5(-e^(-(x-2)^2-(y+2)^2)*10^2.5))-e^(-x^2-y^2)*10^2.8
			return (Math.abs(-Math.pow(x, 3)-Math.pow(y, 3) + 5*(-Math.exp(-(Math.pow((x-2), 2))-(Math.pow((y+2), 2)))*Math.pow(10, 2.5)))-Math.exp(-Math.pow(x, 2)-Math.pow(y, 2))*Math.pow(10, 2.8));
		} else if (terrain == 4) {
			//abs(x^2+y^3)/100+abs(6*e^(-x^2-y^2))
			return (Math.abs(Math.pow(x, 2) + Math.pow(y, 3))/100 + Math.abs(6*Math.exp(-Math.pow(x, 2)-Math.pow(y, 2))));
		} else if (terrain == 5) {
			//-sin(y/5)+1.5*e^(-(x)^2-(y)^2)+1.5*e^(-(x+4)^2-(y+4)^2)+1.5*e^(-(x-4)^2-(y-4)^2)+0.5
			return (-Math.sin(y/5) + 1.5*Math.exp(-Math.pow(x, 2)-Math.pow(y, 2)) + 1.5*Math.exp(-Math.pow((x+4), 2)-Math.pow((y+4), 2)) + 1.5*Math.exp(-Math.pow((x-4), 2)-Math.pow((y-4), 2)) + 0.5);
		} else if( terrain == 6) {
			//abs(x/y)/2
			return (Math.abs(x/y)/2);
		}
		return null;
		//return null;
	}


	public static Vector2 startPos(int terrain) {
		switch (terrain) {
			case (1): return new Vector2(0,0);
			case (2): return new Vector2(-8,0);
			case (3): return new Vector2(0,0);
			case (4): return new Vector2(0,0);
			case (5): return new Vector2(0,0);
			case (6): return new Vector2(0,0);
			default: return new Vector2(0,0);
		}

	}

	public static Vector2 endPos(int terrain) {
		switch (terrain) {
			case (1): return new Vector2(0,1);
			case (2): return new Vector2(8,0);
			case (3): return new Vector2(0,1);
			case (4): return new Vector2(0,1);
			case (5): return new Vector2(0,1);
			case (6): return new Vector2(0,1);
			default: return new Vector2(0,0);
		}

	}

//	public static SandSpot getSand(int terrain) {
//		switch (terrain) {
//			case (1): return new SandSpot();
//			default: return new Vector2(0,0);
//		}
//
//	}
=======
		return null;
	}

	public static void main(String[] args) {
		System.out.println(compute(4, 0, 0));
	}
>>>>>>> 3bfce996481b6212659d267439b275d6bff56830
}
