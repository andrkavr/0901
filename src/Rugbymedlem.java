import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rugbymedlem {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Rugbyklubb> lista = new ArrayList<Rugbyklubb>();
        String data = "lista.csv";
        File minFil = new File("medlemslista.csv");
        System.out.println("*** Välkommen till klubblistan ***");

        readFileData(lista, minFil);

        while (true) {
            System.out.println("1. Sök medlem");
            System.out.println("2. Lägg till medlem");
            System.out.println("3. Ta bort medlem");
            System.out.println("4. Lista alla");
            System.out.println("0. Avsluta");

            int choice = Integer.parseInt(scan.nextLine());

            switch(choice){
                case 1: search(scan, lista);
                break;
                case 2: addPerson(scan, lista);
                break;
                case 3: removePerson(scan, lista);
                break;
                case 4: displayAll(lista);
                break;
                case 0: {
                    if (saveData(minFil, lista)) System.exit(0);
                    else System.out.println("Kunde ej spara fil.");


                }
            }
        }
    }
        private static void readFileData (ArrayList <Rugbyklubb> lista, File minFil){
        try {
            if (minFil.exists() == false) {
                if (minFil.createNewFile() == false) {
                    System.out.println("Kunde inte hitta eller skapa fil " + minFil.getName());
                    throw new Exception("Kunde inte hitta eller skapa filen");
                }
            }
            Scanner fileData = new Scanner(minFil);
            while (fileData.hasNextLine()) {
                String rad = fileData.nextLine();       //Förstår inte detta "stycke"
                lista.add(new Rugbyklubb(rad));
            }
            fileData.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

       public static void search (Scanner scan, ArrayList<Rugbyklubb> lista){
           System.out.println("Ange sökterm: ");
           String searchterm = scan.nextLine();
           boolean hittat = false;

           for (int i = 0; i < lista.size(); i++){
               if(lista.get(i).forName.equals(searchterm)){
                   System.out.println("Telefonnummer är: " + lista.get(i).phoneNr);
                   hittat = true;
               }
           }
           if (hittat == false){
               System.out.println("Kunde ej hitta personen");
           }
    }

    private static void addPerson (Scanner scan, ArrayList<Rugbyklubb> lista){
        System.out.println("Ange förnamn: ");
        String fornamn = scan.nextLine();
        System.out.println("Ange efternamn: ");
        String efternamn = scan.nextLine();
        System.out.println("Ange telefonnummer: ");
        String telenummer = scan.nextLine();
        lista.add(new Rugbyklubb(fornamn, efternamn, telenummer));
    }
    private static void removePerson (Scanner scan, ArrayList<Rugbyklubb> lista){

        System.out.println("Personer i listan: ");
        for (int i = 0; i < lista.size(); i++){
            Rugbyklubb ml = lista.get(i);
            System.out.println((i+1) + ". " + ml.forName + " " + ml.efterName + " " + ml.phoneNr);
        }
        System.out.println("Vem ska lämna ön? ");
        int del = Integer.parseInt(scan.nextLine());
        lista.remove(del -1);
    }
    private static boolean saveData(File minFil, ArrayList<Rugbyklubb> lista){
        try {
            FileWriter writer = new FileWriter(minFil);
            for(int i = 0; i<lista.size(); i++){
                Rugbyklubb p = lista.get(i);
                writer.write(p.forName + ";" + p.efterName + ";" + p.phoneNr + "\n");
            }
            writer.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    private static void displayAll(ArrayList<Rugbyklubb> lista) {
        System.out.println("Antal i listan; " + lista.size());
        String format = "%15s %15s %15s\n";
        System.out.format(format, "Förnamn", "Efternamn", "Telefonnummer");
        for (int i = 0; i < lista.size(); i++) {
            System.out.format(
                    format,
                    lista.get(i).forName, //namn, efternamn, poäng,
                    lista.get(i).efterName,
                    lista.get(i).phoneNr);
        }
    }
}
