import java.util.*;
public class heltal {
    public static void main(String args[]) {
        Scanner tangentbord = new Scanner(System.in);

        System.out.print("Vilken siffra?");
        int num1 = tangentbord.nextInt();

       int result = (num1 % 2);
      /*  switch (result) {
            case 1:
                System.out.println("Ojämnt tal");
                break;
            case 0:
                System.out.println("Jämnt tal");
                break;
            default:
                break;
                */

                if (result%2 == 0) {
                    System.out.println("Talet är jämnt");
                }
                else{
                    System.out.println("Talet är ojämnt");
                }
        }
        }

