import java.util.*;

public class SlotMachine {
    public static void main(String args[]) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);


        System.out.println("Tryck enter för att spela");
        while (true){
        String enter = (sc.nextLine());

        int AntalSlots = 3;
        int[] Symbol = new int[AntalSlots];

        for (int i = 0; i < Symbol.length; i++) {
            Symbol[i] = rand.nextInt(3);
            Symbol[i]++;
            System.out.print(" " + Symbol[i] + " ");
            //lägg till array med namn !, 7 och $ istället för siffor

        }

        for (int i = 0; i < AntalSlots; i++) {
            for (int j = 0; j == i; j++) {
                if (Symbol[0] == Symbol[1] && Symbol[0] == Symbol[2]) {
                    System.out.println("Grattis, du har vunnit");
                }
                else{
                    System.out.println("Du förlorade");
                }
            }
            }
        }
    }
}