import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

public class Dice2 {
    public static void main(String args[]) {
        Random rand = new Random();
        Scanner tbord = new Scanner(System.in);

        System.out.println("Vill du rulla en eller två tärningar?");
        int val = tbord.nextInt();


        int[] options = new int[]{1, 2};
        int position = 0;
        while (position < options.length) {


            int Dice = rand.nextInt(6);
            Dice++;
            if (val == 1) {
                System.out.println("Tärning: " + Dice);
                position = position + 2;
            }
            else if (val == 2) {

                System.out.println("Tärning: " + Dice);
                position = position + 1;
            }
        }

    }

}















/*
public class WhileExempel {
    public static void main(String[] args){
        int[] tal = new int[]{ 5, 4, 9};
        int position = 0;
        while (position < tal.length){
            System.out.println(tal[position]);
            position = position + 1;
        }
    }
}


*/