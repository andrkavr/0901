import java.util.Random;

public class Dice {
    public static void main (String args []){

        Random rand = new Random();


        int Dice = rand.nextInt(6);
        Dice++;
        System.out.println("Slumptal: "+Dice);
    }
}

