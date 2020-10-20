import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class ovn11ny {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PersonInfo> register = new ArrayList<PersonInfo>();
        String data = "data.csv";

        try {
            File myFile = new File("data.csv");
            if (myFile.exists() == false) {
                if (myFile.createNewFile()) {
                    System.out.println("Skapade filen: " + myFile.getName());
                } else {
                    System.out.println("Kunde inte skapa filen: " + myFile.getName());
                    return;
                }
            }
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String rad = myReader.nextLine();
                String[] delar = rad.split(";"); // Cheeky;Breeky;031-589828
                PersonInfo medlem = new PersonInfo(
                        delar[0],
                        delar[1],
                        delar[2]
                );
                register.add(medlem);
            }

            while (true) {
                System.out.println("Välkommen till medlemsregistret.");
                System.out.println("Vad vill du göra?\n 1. Registrera ny medlem \n 2. Visa existerande medlemmar \n 3. Ta bort medlem \n 0. Avsluta");
                int choice = Integer.parseInt(scan.nextLine());


                myReader.close();

                if (choice == 1) {
                    System.out.print("Förnamn: ");
                    String forNamn = scan.nextLine();
                    //  if (forNamn.length() == 0) break;

                    System.out.print("Efternamn: ");
                    String efterNamn = scan.nextLine();

                    System.out.print("Telefonnummer: ");
                    String telNummer = scan.nextLine();

                    register.add(new PersonInfo(forNamn, efterNamn, telNummer));
                }

                //Sortera på förnamn
                else if (choice == 2) {
                    Collections.sort(register, (o1, o2) -> o1.forNamn.compareTo(o2.forNamn));

                    FileWriter myWriter = new FileWriter("data.csv");

                    for (int i = 0; i < register.size(); i++) {

                        PersonInfo memba = register.get(i);
                        myWriter.write(
                                memba.forNamn + ";" +
                                        memba.efterNamn + ";" +
                                        memba.telNummer + "\n"
                        );
                    }
                    myWriter.close();

                    System.out.println("Skrev till fil: " + data);


                    //utskrift
                    System.out.println("Antal i listan; " + register.size());
                    String format = "%15s %15s %15s\n";
                    System.out.format(format, "Förnamn", "Efternamn", "Telefonnummer");
                    for (int i = 0; i < register.size(); i++) {
                        System.out.format(
                                format,
                                register.get(i).forNamn, //namn, efternamn, poäng,
                                register.get(i).efterNamn,
                                register.get(i).telNummer);
                    }
                }
                //ta bort medlem
            else if (choice == 3) {
               /* System.out.println("Antal i listan; " + register.size());
                String format = "%15s %15s %15s\n";
                System.out.format(format, "Förnamn", "Efternamn", "Telefonnummer");
                for (int i = 0; i < register.size(); i++) {
                    System.out.format(
                            format,
                            register.get(i).forNamn, //namn, efternamn, poäng,
                            register.get(i).efterNamn,
                            register.get(i).telNummer);
                }

                */
                for (int i = 0; i < register.size(); i++) {
                    System.out.println("Personer i listan");
                    PersonInfo p = register.get(i);
                    System.out.println((i + 1) + ". " + p.forNamn + " " + p.efterNamn + " " + p.telNummer);
                }
                    System.out.println("Vem ska lämna ön?");
                int delete = Integer.parseInt(scan.nextLine());
                register.remove(delete-1);

                  /* scan.next();
                    String delete = scan.nextLine();
                    if (register.get(i).equals(delete)){
                        register.remove(register);

                   */

                  //  register.remove(new String (scan.nextLine()));


                    // register.removeAll(register);

                }
                else if (choice == 0) {
                    return;
                }
            }

        } catch (Exception exceptionInfo) {
            System.out.println("An error occurred.");
            exceptionInfo.printStackTrace();
        }
    }
}