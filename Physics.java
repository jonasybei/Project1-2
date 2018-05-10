public class Physics {
  double x;
  double y;
  double xVelocity;
  double yVelocity;
  double xAcceleration;
  double yAcceleration;
  double xSlope;
  double ySlope;
  double mu;
  double FINAL G = 9.81;
  double FINAL H = 0.0125;



  public double xSlopeCalculator(){

  }

  public double ySlopeCalculator(){

  }


// We have to update mu after each timestep, to be sureit mu=muSand or mu=muGrass /// CHECK FROM BALL CLASS
  public double accelerationFormulas(xSlope, ySlope,xAcceleration, yAcceleration, xVelocity, yVelocity){
  xAcceleration= -G * xSlope - (G * mu * xVelocity)(xVelocity^2 + yVelocity^2)
  yAcceleration= -G * ySlope - (G * mu * yVelocity)/(xVelocity^2 + yVelocity^2)
}


  //fourth.order runge-Kutta
  public double xRungeKutta(double wi, double ti){
    double result;
    int k1 = H * xSlopeCalculator(ti, wi);
    int k2 = H * xSlopeCalculator(ti + H/3, wi + k1/3);
    int k3 = H * xSlopeCalculator(ti + 2/3 * H, w - k1/3 + k2);
    int k4 = H * xSlopeCalculator(ti + H, wi + k1 - k2 + k3);
    result =  wi + (k1 + 3 * k2 + 3 * k3 + k4)/8;
    return result;
  }

  public double yRungeKutta(double wi, double ti){
    double result;
    int k1 = H * ySlopeCalculator(ti, wi);
    int k2 = H * ySlopeCalculator(ti + H/3, wi + k1/3);
    int k3 = H * ySlopeCalculator(ti + 2/3 * H, w - k1/3 + k2);
    int k4 = H * ySlopeCalculator(ti + H, wi + k1 - k2 + k3);
    result =  wi + (k1 + 3 * k2 + 3 * k3 + k4)/8;
    return result;
  }
}
//wi = xVelocity.
//ti = x.
