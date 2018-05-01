package com.mygdx.game.io;

//This parser utilizes the "Shunting-yard algorithm".
//A detailed explanation about this algorithm can be found here: https://en.wikipedia.org/wiki/Shunting-yard_algorithm
public class Parser {

	String sin = "sin";
	String cos = "cos";
	String tan = "tan";
	String power = "^";

	public static double calculate(String function, double x, double y) {

		if((function.substring(0, 1)).equals("x")) {
			return x;
		} else if((function.substring(0, 1)).equals("y")) {
			return y;
		}

		if(function.substring(0, 3).equals("sin")) {
			return Math.sin(calculate(function.substring(3), x, y));
		} else if(function.substring(0, 3).equals("cos")) {
			return Math.cos(calculate(function.substring(3), x, y));
		} else if(function.substring(0, 3).equals("tan")) {
			return Math.tan(calculate(function.substring(3), x, y));
		}
		return 0;
	}

	public static void main(String[] agrs) {
		System.out.println(calculate("sin(sin(x))", 1, 1));
	}

}
