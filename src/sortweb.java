import java.util.*;
public class sortweb {

    public static void main(String args[]) {

        Random rand = new Random();

        int antal = 6;
        int[] tal = new int[antal];

        for (int i = 0; i < tal.length; i++) {
            tal[i] = rand.nextInt(6);
            tal[i]++;
            System.out.println("Tärningsresultat: " + tal[i]);
        }

        for (int i = 0; i < antal; i++) {
            for (int j = i + 1; j < antal; j++) {
                if (tal[i] > tal[j]) {
                    int temp = tal[i];
                    tal[i] = tal[j];
                    tal[j] = temp;
                }
            }
        }
        System.out.print("Ordning: ");
        for (int i = 0; i < antal; i++) {
            System.out.print(tal[i] + ", ");
        }
    }
}
