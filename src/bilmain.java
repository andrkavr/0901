import java.util.*;
public class bilmain {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        //Bil brumbrum = new Bil();

        System.out.println("*** Välkommen till Billistan ***");
        /*\n Hur många bilar vill du spara?");
        String antal = scan.nextLine();
        //int [] amount = new int[antal];
        int amount = Integer.parseInt(antal);

         */

        //ArrayList<String> car = new ArrayList<String>();
        ArrayList<Bil> car = new ArrayList<Bil>();
        // car.add(scan.nextLine());


        //int antal = scan.nextInt();
        //car.add(scan.nextLine());


        while (true) {

            //for (int i = 0; i < amount; i++) {
                System.out.println("Ange färg: ");
                String color = scan.nextLine();
                //car.add(scan.nextLine());
                if (color.length() == 0)
                    break;
                System.out.println("Ange bilmärke: ");
                String model = scan.nextLine();
                //car.add(scan.nextLine());
                System.out.println("Ange hästkrafter: ");
                String carhorsePowers = scan.nextLine();
                //int carhorsePowers = Integer.parseInt(horse);
                // car.add(scan.nextLine());
                System.out.println("Ange tillverkningsår ");
                String manufactureDate = scan.nextLine();
                // car.add(scan.nextLine());
                //int year = Integer.parseInt(manufactureDate);
                //Lägg till ParseInt

            Bil vroom = new Bil(color, model, Integer.parseInt(carhorsePowers), Integer.parseInt(manufactureDate));
                car.add(vroom);
              //  System.out.println(car(i));
          //  }
        }
        //utskrift
            String format = "%15s %15s %7s %7s\n";
           if (car.size() > 0) {
            System.out.format(format, "Modell", "Färg", "Hästkrafter", "Tillverkningsår");
            for (int i = 0; i < car.size(); i++) {
                System.out.format(
                        format,
                        car.get(i).carModel, //namn, efternamn, poäng,
                        car.get(i).carColor,
                        car.get(i).carhorsePowers,
                        String.valueOf(car.get(i).carmanufactureDate));

            }
        }
    }
}

