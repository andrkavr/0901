
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileExempel {
    public static void main(String[] args) {
        ArrayList<Person> personer = new ArrayList<>();
        String filnamn = "filename.txt";


        try {
            // Öppna fil
            File myFile = new File(filnamn);
            if (myFile.exists() == false){
                if (myFile.createNewFile()) {
                    System.out.println("Skapade filen: " + myFile.getName());
                } else {
                    System.out.println("Kunde inte skapa filen: " + myFile.getName());
                }
            }

            // Läs in fil itll ArrayList
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                String rad = myReader.nextLine();
                String[] delar = rad.split(";"); // "Jon;Mjölnevik;1977-03-18;23:00"
                Person person = new Person(
                        delar[0],
                        delar[1],
                        delar[2],
                        delar[3]
                );
                personer.add(person);
            }
            myReader.close();

            // Skapa fler poster i listan personer
            Scanner tangentbord = new Scanner(System.in);
            while (true) {
                System.out.println("Antal i listan; " +  personer.size());

                System.out.print("Förnamn: ");
                String fornamn = tangentbord.nextLine();
                if (fornamn.length() == 0) break;

                System.out.print("Efternamn: ");
                String efternamn = tangentbord.nextLine();

                System.out.print("Födelsedatum: ");
                String datum = tangentbord.nextLine();

                System.out.print("Födelseklockslag: ");
                String time = tangentbord.nextLine();

                personer.add(new Person(fornamn, efternamn, datum, time));
            }

            // Sortera listan baserat på födelsedatum
            Collections.sort(personer,   (o1, o2) -> o1.birthDate.compareTo(o2.birthDate));

            // Kod för att spara listan till fil
            FileWriter myWriter = new FileWriter(filnamn);

            for (int i = 0; i < personer.size(); i++){
                Person p = personer.get(i);
                myWriter.write(
                        p.firstName + ";" +
                                p.lastName + ";" +
                                p.birthDate.toString() + ";" +
                                p.birthTime.toString() +
                                "\n"
                );
            }
            //myWriter.flush();
            myWriter.close();

            //Skriv listans innehåll till skärm
            System.out.println("Skrev till fil: " + filnamn);
            for (int i = 0; i < personer.size(); i++){
                Person p = personer.get(i);
                System.out.println(
                        p.firstName + ";" +
                                p.lastName + ";" +
                                p.birthDate.toString() + ";" +
                                p.birthTime.toString()
                );
            }

        } catch (Exception exceptionInfo) {
            System.out.println("An error occurred.");
            exceptionInfo.printStackTrace();
        }
    }
}
