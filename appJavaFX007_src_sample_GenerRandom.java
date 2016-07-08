package sample;

import java.util.Random;

/**
 * Created by SETICOV on 07.07.2016.
 */
public class GenerRandom {
   static Double varRandom;
    private static Random rnd=new Random();

    public static void genRandom(){

        setVarRandom(rnd.nextDouble()*10);//
    }

    public static Double getVarRandom() {
        return varRandom;
    }

    public static void setVarRandom(Double varRandom) {
        GenerRandom.varRandom = varRandom;
    }
}
