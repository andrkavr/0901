import java.util.Random;
public class jankentest {
    public static void main(String args[]) {

        Random rand = new Random();


        int Dice = rand.nextInt(3);

        int cpick = (Dice);

        switch (cpick) {

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