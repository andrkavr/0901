import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class Medlemsregister {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<PersonInfo> register = new ArrayList<PersonInfo>();
        String data = "data.csv";
        //while (true) {
            System.out.println("Välkommen till medlemsregistret.");
          //  System.out.println("Vad vill du göra?\n 1. Registrera ny medlem \n 2. Visa existerande medlemmar");
            // int choice = scan.nextInt();

            // if (choice == 1){ kanske bättre med en switch
            try {
                File myFile = new File("data.csv");
                if (myFile.exists() == false) {
                    if (myFile.createNewFile()) {
                        System.out.println("Skapade filen: " + myFile.getName());
                    } else {
                        System.out.println("Kunde inte skapa filen: " + myFile.getName());
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
                myReader.close();

                //skapa ny medlemmar
                while (true) {
                    System.out.println("Antal i listan; " + register.size());

                    System.out.print("Förnamn: ");
                    String forNamn = scan.nextLine();
                    if (forNamn.length() == 0) break;

                    System.out.print("Efternamn: ");
                    String efterNamn = scan.nextLine();

                    System.out.print("Telefonnummer: ");
                    String telNummer = scan.nextLine(); //int telNummer = integer.valueOf(scan.nextLine();

                    register.add(new PersonInfo(forNamn, efterNamn, telNummer)); //Integer.parseInt(telNummer)
                }
                //Sortera på förnamn
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
                for (int i = 0; i < register.size(); i++) {
                    PersonInfo memba = register.get(i);
                    System.out.println(
                            memba.forNamn + ";" +
                                    memba.efterNamn + ";" +
                                    memba.telNummer
                    );
                }

            } catch (Exception exceptionInfo) {
                System.out.println("An error occurred.");
                exceptionInfo.printStackTrace();
            }
        }
    }
//}
