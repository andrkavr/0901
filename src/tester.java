import java.util.*;

public class tester {
    public static void main(String[] args) {
        Scanner tangentbord = new Scanner (System.in);

        System.out.print("Första siffran? ");
        double num1 = tangentbord.nextInt();



        System.out.println("Andra siffran? ");
        double num2 = tangentbord.nextInt();

        System.out.println("Summa eller kvot? ");
        double num3 = tangentbord.nextInt();

            double sum = num1 / num2;
            System.out.println(sum);
            tangentbord.nextLine();
        }
    }