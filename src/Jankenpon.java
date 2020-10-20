
import java.util.Random;
import java.util.Scanner;

public class Jankenpon {
    public static void main (String args[]) {
        Scanner tangentbord = new Scanner(System.in);

        System.out.println("Sten, sax eller påse?");

        String dittval = tangentbord.nextLine();

        System.out.println("Du valde: "+dittval);
        System.out.print("Datorn valde: ");
        slump();
    }


          /*  if (tangentbord != 1) {
                System.out.print("Du får bara välja en. Sten, sax eller påse. ");
            }
            else {
                slump(args);
            }
        */


        public static void slump () {
            Random rand = new Random();

            int Dice = rand.nextInt(3);

            //int cpick = (Dice);

            switch (Dice) {

                case 0:
                    System.out.println("Sten");
                    break;
                case 1:
                    System.out.println("Sax");
                    break;
                case 2:
                    System.out.println("Påse");
                    break;

            }

        }

}