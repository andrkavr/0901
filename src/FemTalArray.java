import java.util.Random;
public class FemTalArray {
    public static void main(String args[]) {

        int antal = 6;
        int[] tal = new int[antal];
        Random rand = new Random();

        for (int i = 0; i < tal.length; i++) {
            tal[i] = rand.nextInt(6);
            tal[i] = tal[i] + 1;
        }


        for (int i = 0; i < tal[i]; i++) {

            for (int j = tal[1] + 1; j < antal; j++) {
                if (tal[i] > tal[j]) {
                    int temp = tal[i];
                    tal[i] = tal[j];
                    tal[j] = temp;
                    System.out.println(tal[i]);
                }
            }
        }
                   /* System.out.print("Storleksordning ");
                    for (int i = 0; i < tal[i] - 1; i++)
                    {
                        System.out.print(tal[i] + ", ");
                    }
                    System.out.print(tal[tal[1] - 1]);

                    */

      /* if (tal[0] > tal[1]){
            int temp = tal[0];
            tal[0] = tal[1];
            tal[1] = temp;

       */

    }
}
/*
        for (int i = 0; i < tal.length; i++){
            System.out.println(tal[i]);
        }
*/
