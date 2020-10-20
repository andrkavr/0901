import java.util.*;
public class Dice3 {
        public static void main(String args[]) {
            Random rand = new Random();
            Scanner tbord = new Scanner(System.in);

            System.out.println("Hur många tärningar vill du kasta?");
            int choice = tbord.nextInt();



            for (int val = 0; val <choice; val++) {

                int Dice = rand.nextInt(6) +1;

                System.out.println("Tärning:" +Dice);


            }

        }
}
