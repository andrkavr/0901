import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class TvProgram {

    public static void main(String[] args) {
       /* Skapa programmet TvProgram. Programmet ska låta användaren planera sin TV-kväll genom att skriva in vilket klockslag ett program börjar, när det slutar samt vad programmet heter.
        Användaren ska kunna lista innehållet av en ArrayList som innehåller alla program. Utskriften ska vara sorterad på när ett program börjar.
        Programmet ska ha en meny med följande alternativ
        Lägg till program
        Lista program
        Avsluta */

        Scanner scan = new Scanner(System.in);
        ArrayList<tvplanner> plan = new ArrayList<tvplanner>();
        while (true) {

            System.out.println("*** Välkommen till LZ tv ***");
            System.out.println("Meny \n (1) Lägg till program \n (2) Lista program \n (3) Avsluta");
            int choice = scan.nextInt();
            //scan.nextLine();

            if (choice == 1) {

               // System.out.println("Ange programnamn: ");
                //String progName = scan.nextLine();
               /* if (progName.length() == 0)
                    break;

                */
                System.out.println("Ange programnamn: ");
                String progName = scan.nextLine();
                System.out.println("Ange starttid: ");
                String startTime = scan.nextLine();
                System.out.println("Ange sluttid: ");
                String stopTime = scan.nextLine();
                System.out.println("Ange datum: ");
                String viewTime = scan.nextLine();

                tvplanner tvprog = new tvplanner(progName, LocalTime.parse(startTime), LocalTime.parse(stopTime), LocalDate.parse(viewTime));
                plan.add(tvprog);
            }

            else if (choice == 2) {
                String format = "%15s %15s %7s\n";
                if (plan.size() > 0) {
                    System.out.format(format, "Program", "Startar", "Slutar");

                    Collections.sort(plan, ((o1, o2) -> o1.startTime.compareTo(o2.startTime)));

                    for (int i = 0; i < plan.size(); i++) {
                        System.out.format(format,
                                plan.get(i).progName,
                                plan.get(i).startTime,
                                plan.get(i).stopTime
                        );
                    }
                }
            }

            else {
                System.out.println("Tack för idag!");
                break;
            }
        }
    }
}

//Collections.sort(plan, (o1,o2) -> o1.plan.compareTo(o2.plan));