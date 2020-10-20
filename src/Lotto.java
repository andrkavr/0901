import java.util.*;
public class Lotto {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        int[] lotto = new int[7];

        System.out.println("Ange dina lottonummer");
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = scan.nextInt();

        }
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(" "+lotto[i]);

        }

/*
    public static void ratt() {
        Random rand = new Random();

        int antal = 7;
        int[] RandoNumbers = new int[antal];

        for (int i = 0; i < RandoNumbers.length; i++) {
            RandoNumbers[i] = rand.nextInt(1000);
            System.out.print(" " + RandoNumbers[i] + " ");
        }

 */
    }
}