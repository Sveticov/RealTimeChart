package sample;

import java.util.Random;

/**
 * Created by SETICOV on 07.07.2016.
 */
public class RandomValue {
  double var1;
    double var2;


    public RandomValue(double var2, double var1) {
        this.var2 = var2;
        this.var1 = var1;
    }
    public static double setRandomVAR(){
        Random rnd=new Random();
     double var0=rnd.nextDouble();

    return var0;
    }
}
