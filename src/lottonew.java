import java.util.*;
public class lottonew {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // Random rand = new Random();

        int[] lotto = new int[7];

        System.out.println("Ange dina lottonummer");
//ny for-sats för att få till inläsning först

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = scan.nextInt();
        }
        for (int i = 0; i < lotto.length; i++) {

            for (int j = i + 1; j < lotto.length; j++) {
                if (lotto[i] > lotto[j]) {
                    int temp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;

                }
            }
        }

        System.out.print("Din rad i ordning: ");
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + ", ");
        }
        datorval();
    }



    public static void datorval() {

        Random nyrand = new Random();

        int DatorLotto = 7;
        int[] Symbol = new int[DatorLotto];

        for (int i = 0; i < Symbol.length; i++) {
            Symbol[i] = nyrand.nextInt(20);
            Symbol[i]++;
           // System.out.print("Den korrekta raden: ");
        }


        for (int i = 0; i < DatorLotto; i++) {
            for (int j = i + 1; j < DatorLotto; j++) {
                if (Symbol[i] > Symbol[j]) {
                    int temp = Symbol[i];
                    Symbol[i] = Symbol[j];
                    Symbol[j] = temp;
                }
            }
        }
        System.out.print("Den korrekta raden: ");
        for (int i = 0; i < DatorLotto; i++) {
            System.out.print(Symbol[i] + ", ");
        }
    }



            }


