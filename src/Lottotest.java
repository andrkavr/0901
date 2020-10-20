import java.util.*;
public class Lottotest {
    public static void main(String args[]) {

        Random rand = new Random();
        int[] vinst = new int[7];
        int[] guess = new int[vinst.length];
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Välkommen till Newton Casino ***");

        //Läs in användarens gissningar
        for (int i = 0; i < guess.length; i++) {
            System.out.print("Ange lottonummer: " + (i + 1) + ": ");
            int tal = scan.nextInt();
            guess[i] = tal;
        }
        //Slumpa fram tal
        for (int i = 0; i < vinst.length; i++) {
            int tal = rand.nextInt(35) + 1;
            vinst[i] = rand.nextInt(35) + 1;
            for (int j = 0; j <= i; j++) {
                if (vinst[j] == tal) {
                    j = 0;
                    tal = rand.nextInt(35) + 1;
                }
            }
            vinst [i] = tal;

        }
        //Skriv ut antal rätt
        int antalRatt = 0;
        for (int i = 0; i < guess.length; i++){
            for (int j = 0; j < vinst.length; j++){
                if (guess[j] == vinst[i]) {
                    antalRatt++;

                }
            }
        }
        System.out.println("Antal rätt: " + antalRatt);
        System.out.print("Vinnande lottorad var: ");
        for(int i = 0; i < vinst.length; i++){
            System.out.print("[" +vinst[i] + "] ");
        }
    }
}