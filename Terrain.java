import java.lang.Math.*;

//This class computes the terrain with the use of functions. Those can be found here:
//https://docs.google.com/document/d/1ZUv9NAnBHs384mxa-9tkk39cExyGSKAK1exx1yJGvn0/edit?usp=sharing

public class Terrain {
	public static double compute(int terrain, double x, double y) {
		if (terrain == 1) {
			//e^x-e^y-e^(-x^2-y^2)*10^4
			return ((Math.exp(x)-Math.exp(y)-(Math.exp(-Math.pow(x, 2)-Math.pow(y, 2)))*Math.pow(10, 4)));
		} else if(terrain == 2) {
			//x^2+y^3+e^(-x^2-y^2)*10^2.8
			return (Math.pow(x, 2)+Math.pow(y, 3)+(Math.exp(-Math.pow(x, 2)-Math.pow(y, 2))*Math.pow(10, 2.8)));
		} else if (terrain == 3) {
			//1/200*(-x^3-y^3+5(-e^(-(x+5)^2-(y+5)^2)*10^3)+2000)

		} else if(terrain == 4) {
			//abs(-x^3-y^3+5(-e^(-(x+5)^2-(y+5)^2)*10^2.5))-e^(-x^2-y^2)*10^2.8

		} else if (terrain == 5) {
			//abs(x^2+y^3+e^(-x^2-y^2)*10^2.8)
			return Math.abs(Math.pow(x, 2)+Math.pow(y, 3)+(Math.exp(-Math.pow(x, 2)-Math.pow(y, 2))*Math.pow(10, 2.8)));
		} else if (terrain == 6) {
			//-(sin(1/5y)+e^(-x^2-y^2)*1.5)
			return (-(Math.sin(1/5*y)+(Math.exp(-Math.pow(x, 2)-Math.pow(y, 2))*1.5)));
		} else if( terrain == 7) {
			//abs(x/y)
			return (Math.abs(x/y));
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println(compute(6, 0, 0));
	}

}
