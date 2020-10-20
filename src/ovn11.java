import java.util.*;
public class ovn11 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // Random rng = new Random();
/*Skapa ett program som fyller en arraylist med tal.
När användaren trycker enter utan att ha angivit ett tal eller anger talet 0 så skrivs medelvärdet ut på skärmen och programmet avslutas.
 */
        ArrayList<Integer> points = new ArrayList<Integer>();
        //Kolla upp hur ett specifikt värde ska anges
      /*  for (int i = 0; i < points.size(); i++) {

        }

       */
        //Ange värden
        System.out.println("Ange siffror: ");
        while (scan.hasNextInt()) {
            points.add(scan.nextInt());
        }

        //uträkning
        int total = 0;
        int avg;

        for (int i = 0; i < points.size(); i++) {

            total = total + points.get(i);
        }
            avg = total / points.size();

            System.out.println("Medelvärdet är: " + avg);
          //  System.out.format("Average is %8s%1f",avg);


        //Se till att räkna ut och skriva ut medelvärde


    }

}
