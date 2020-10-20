import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileReader;

public class uppdtv {
    private static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        File sparaTV = new File("TVprogram.csv");
        ArrayList<tvplanner> plan = new ArrayList<tvplanner>();
        ArrayList<UserTV> users = new ArrayList<UserTV>();
        //  Scanner userChecker = new Scanner("users.pwd");


        System.out.println("*** Välkommen till LZ tv ***");
        System.out.println("Var vänlig och logga in");
        logIn();

        while (true) {

            System.out.println("Meny \n " + "(1) Lägg till program \n (2) Visa programlista \n (3) Sök efter program \n (4) Ta bort program \n (5) Lista användare \n (6) Lägg till användare \n (7) Ta bort användare \n (0) Avsluta");
            int choice = Integer.parseInt(scan.nextLine());

            readFileData(plan, "Tvprogram.csv");
            // readFileUserData(users, inlogg);

            switch (choice) {
                case 1:
                    sparaTVprog(scan, plan);
                    break;
                case 2:
                    visaLista(plan);
                    break;
                case 3:
                    search(scan, plan);
                    break;
                case 4:
                    removeProgram(scan, plan);
                    break;
                case 5:
                    userPrint();
                    break;
                case 6:
                    addUser(scan, users);
                    break;
                case 7:
                    removeUser(scan, users);
                    break;
                case 0: {
                    if (saveData(sparaTV, plan)) break;
                    else System.out.println("Kunde ej spara fil.");
                    System.exit(0);

                }
            }
        }
    }

    public static void sparaTVprog(Scanner scan, ArrayList<tvplanner> plan) {
        // while(true) {
        System.out.println("Ange programnamn: ");
        String progName = scan.nextLine();
        System.out.println("Ange starttid: ");
        String startTime = scan.nextLine();
        System.out.println("Ange sluttid: ");
        String stopTime = scan.nextLine();
        System.out.println("Ange datum: ");
        String viewDate = scan.nextLine();

        tvplanner tvprog = new tvplanner(progName, LocalTime.parse(startTime), LocalTime.parse(stopTime), LocalDate.parse(viewDate));
        plan.add(tvprog); //kanske göra om denna. men den får duga tillsv.
        // }
    }

    private static void visaLista(ArrayList<tvplanner> plan) {
        System.out.println("Program i listan; " + plan.size());
        String format = "%15s %15s %15s\n";
        System.out.format(format, "Program", "Starttid", "Sluttid");
        Collections.sort(plan, ((o1, o2) -> o1.startTime.compareTo(o2.startTime)));
        for (int i = 0; i < plan.size(); i++) {
            System.out.format(
                    format,
                    plan.get(i).progName, //namn, efternamn, poäng,
                    plan.get(i).startTime,
                    plan.get(i).stopTime);
        }
    }

    private static void readFileData(ArrayList<tvplanner> plan, String filename) {
        File sparaTV = new File(filename);
        try {
            if (!sparaTV.exists()) {
                if (!sparaTV.createNewFile()) {
                    System.out.println("Kunde ej hitta eller skapa filen: " + sparaTV.getName());
                    throw new Exception("Kunde inte hitta eller skapa filen.");
                }
            }
            Scanner readFile = new Scanner(sparaTV);
            while (readFile.hasNextLine()) {
                String rad = readFile.nextLine();
                plan.add(new tvplanner(rad));
            }
            readFile.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean saveData(File sparaTV, ArrayList<tvplanner> plan) {
        try {
            FileWriter writer = new FileWriter(sparaTV);
            for (int i = 0; i < plan.size(); i++) {
                tvplanner p = plan.get(i);
                writer.write(p.progName + ";" + p.startTime + ";" + p.stopTime + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void removeProgram(Scanner scan, ArrayList<tvplanner> plan) {

        System.out.println("Program i listan: ");
        for (int i = 0; i < plan.size(); i++) {
            tvplanner ml = plan.get(i);
            System.out.println((i + 1) + ". " + ml.progName + " " + ml.startTime + " " + ml.stopTime);
        }
        System.out.println("Vilket ska tas bort? ");
        int del = Integer.parseInt(scan.nextLine());
        plan.remove(del - 1);
    }

    public static void search(Scanner scan, ArrayList<tvplanner> plan) {
        System.out.println("Ange program: ");
        String searchterm = scan.nextLine();
        boolean hittat = false;

        for (int i = 0; i < plan.size(); i++) {
            if (plan.get(i).progName.equals(searchterm)) {
                System.out.println("Programmet startar: " + plan.get(i).startTime);
                hittat = true;
            }
        }
        if (hittat == false) {
            System.out.println("Kunde ej hitta programmet");
        }
    }

    public static void addUser(Scanner scan, ArrayList<UserTV> users) {
        System.out.println("Ange användarnamn: ");
        String userName = scan.nextLine();
        System.out.println("Ange lösenord: ");
        String pswrd = scan.nextLine();
        System.out.println("Ange behörighet: ");
        String level = scan.nextLine();

        users.add(new UserTV(userName, pswrd, UserTV.Clearance.valueOf(level)));
        saveUserData(new UserTV(userName, pswrd, UserTV.Clearance.valueOf(level))
        );

    }

    private static void removeUser(Scanner scan, ArrayList<UserTV> users) {

        System.out.println("Personer i listan: ");
        for (int i = 0; i < users.size(); i++) {
            UserTV ml = users.get(i);
            System.out.println((i + 1) + ". " + ml.getUserName() + " " + ml.getCredentials());
        }
        System.out.println("Vem ska lämna ön? ");
        int del = Integer.parseInt(scan.nextLine());
        users.remove(del - 1);
    }

  /*  private static void readFileUserData(ArrayList<userTV> users, File inlogg) {
        try {
            if (!inlogg.exists()) {
                if (!inlogg.createNewFile()) {
                    System.out.println("Kunde ej hitta eller skapa filen: " + inlogg.getName());
                    throw new Exception("Kunde inte hitta eller skapa filen.");
                }
            }
            Scanner readFile = new Scanner(inlogg);
            while (readFile.hasNextLine()) {
                String row = readFile.nextLine();
                users.add(new userTV(row));
            }
            readFile.close();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

   */

    private static String[] getUsersFromFile() {
        File file = new File("users.pwd");
        ArrayList<String> data = new ArrayList<String>();
        try {
            if (!file.exists()) {
                System.out.println("Could not find file users.pwd");
                return null;
            }
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                data.add(readFile.nextLine());
            }
            readFile.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

    private static void saveUserData(UserTV user) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.pwd", true)));
            out.println(user.getUserName() + ";" + user.getPassword() + ";" + user.getCredentials());
            out.close();
        } catch (Exception ignored) {

        }
    }

    private static boolean checkUser(String username, String password) {
        //Öppna och läsa från fil
        boolean found = false;
        for (String user : getUsersFromFile()) {
            String[] values = user.split(";");

            if (username.equals(values[0]) &&
                    password.equals(values[1])) {
                found = true;
                System.out.println("Välkommen!");
                //sätt variabel user, annars fel uppgifter som nedan.
            }
        }
        if (!found) {
            System.out.println("Fel uppgifter. Var vänlig försök igen.");
            //kalla på logIn
            logIn();
        }
        return false;
    }

    private static boolean logIn() {
        System.out.print("Ange användarnamn: ");
        String anvandarnamn = scan.nextLine();
        System.out.print("Ange lösenord: ");
        String passwd = scan.nextLine();
        return checkUser(anvandarnamn, passwd);
    }

    /* private static void viewUsers (ArrayList<userTV> users, File ){
       System.out.println("Användare: " + users.size());
        String format = "%15s %15s %15s\n";
        System.out.format(format, "Användarnamn", "Behörighet", "Lösenord");
        Collections.sort(users, ((o1, o2) -> o1.getUserName().compareTo(o2.getUserName())));
        for (int i = 0; i < users.size(); i++) {
            System.out.format(
                    format,
                    users.get(i).getUserName(), //namn, efternamn, poäng,
                    users.get(i).getCredentials(),
                    users.get(i).getPassword());

        */
    private static void userPrint() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("users.pwd"));
            String line;
            while ((line = in.readLine()) != null) {


                System.out.println(line);
            }
            in.close();
        } catch (Exception ignored) {

        }
    }
}
