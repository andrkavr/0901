import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class upp2tv {
    private static final Scanner scan = new Scanner(System.in);
    private static UserTV userTV = null;
    private static final ArrayList<String> menuItems = new ArrayList<>();

    public static void main(String[] args) {

        File sparaTV = new File("TVprogram.csv");
        File newPwd = new File("users.pwd");
        ArrayList<tvplanners> plan = new ArrayList<tvplanners>();
        ArrayList<UserTV> users = new ArrayList<UserTV>();
        //  Scanner userChecker = new Scanner("users.pwd");

        readFileData(plan, "Tvprogram.csv");
        readFileUserData(users, newPwd);

        System.out.println("*** Välkommen till LZ tv ***");
        System.out.println("Var vänlig och logga in");
        logIn();
        addMenuItems();

        while (true) {
          /*  for (int i = 0; i < users.size(); i++) {
                if (users.get(i).credentials.equals(userTV.Clearance.USER)) {
                    System.out.println("Meny \n " + "(1) Visa Programlista \n (2) Sök efter program \n (0) Avsluta \n");
                } else if (users.get(i).credentials.equals(userTV.Clearance.ADMIN)) {
                    System.out.println("Meny \n " + "(1) Visa Programlista \n (2) Sök efter program \n (3) Lägg till program \n (4) Ta bort program \n (0) Avsluta \n");
                } else if (users.get(i).credentials.equals(userTV.Clearance.SUPERUSER)) {
                    System.out.println("Meny \n " + "(1) Visa Programlista \n (2) Sök efter program \n (3) Lägg till program \n (4) Ta bort program \n (5) Lista användare \n (6) Lägg till användare \n (7) Ta bort användare \n (0) Avsluta");
                }
            }

           */
            menuPrint();
            System.out.print("Val: ");
            int choice = scan.nextInt();


            switch (menuItems.get(choice - 1)) {
                case "Visa Programlista":
                    visaLista(plan);
                    break;
                case "Sök efter program":
                    search(scan, plan);
                    break;
                case "Lägg till program":
                    sparaTVprog(plan);
                    break;
                case "Ta bort program":
                    removeProgram(scan, plan);
                    break;
                case "Lista användare":
                    viewUsers(users);
                    break;
                case "Lägg till användare":
                    addUser(scan, users);
                    break;
                case "Ta bort användare":
                    removeUser(scan, users);
                    break;
                case "Avsluta":
                    if (saveData(sparaTV, plan) && userSaveRegistry(newPwd, users)) System.exit(0);
                    else System.out.println("Kunde ej spara fil.");


            }
        }
    }

    public static void sparaTVprog(ArrayList<tvplanners> plan) {
        // while(true) {
        scan.nextLine();
        System.out.println("Ange programnamn: ");
        String progName = scan.nextLine();
        System.out.println("Ange starttid: ");
        String startTime = scan.nextLine();
        System.out.println("Ange sluttid: ");
        String stopTime = scan.nextLine();
        System.out.println("Ange datum: ");
        String viewTime = scan.nextLine();

        tvplanners tvprog = new tvplanners(progName, LocalTime.parse(startTime), LocalTime.parse(stopTime), LocalDate.parse(viewTime));
        plan.add(tvprog); //kanske göra om denna. men den får duga tillsv.
        // }
    }

    private static void visaLista(ArrayList<tvplanners> plan) {
        System.out.println("Program i listan; " + plan.size());
        String format = "%15s %15s %15s %15s\n";
        System.out.format(format, "Program", "Starttid", "Sluttid", "Datum");
        Collections.sort(plan, ((o1, o2) -> o1.startTime.compareTo(o2.startTime)));
        for (int i = 0; i < plan.size(); i++) {
            System.out.format(
                    format,
                    plan.get(i).progName, //namn, efternamn, poäng,
                    plan.get(i).startTime,
                    plan.get(i).stopTime,
                    plan.get(i).viewDate);
        }
    }
    private static void readFileData(ArrayList<tvplanners> plan, String filename) {
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
                plan.add(new tvplanners(rad));
            }
            readFile.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean saveData(File sparaTV, ArrayList<tvplanners> plan) {
        try {
            FileWriter writer = new FileWriter(sparaTV);
            for (int i = 0; i < plan.size(); i++) {
                tvplanners p = plan.get(i);
                writer.write(p.progName + ";" + p.startTime + ";" + p.stopTime + ";" + p.viewDate + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void removeProgram(Scanner scan, ArrayList<tvplanners> plan) {

        System.out.println("Program i listan: ");
        for (int i = 0; i < plan.size(); i++) {
            tvplanners ml = plan.get(i);
            System.out.println((i + 1) + ". " + ml.progName + " " + ml.startTime + " " + ml.stopTime);
        }
        System.out.println("Vilket ska tas bort? ");
        int del = Integer.parseInt(scan.nextLine());
        plan.remove(del - 1);
    }

    public static void search(Scanner scan, ArrayList<tvplanners> plan) {
        System.out.println("Ange program: ");
        String searchterm = scan.nextLine();
        boolean hittat = false;

        for (int i = 0; i < plan.size(); i++) {
            if (plan.get(i).progName.equals(searchterm)) {
                System.out.println("Programmet startar: " + plan.get(i).startTime);
                hittat = true;
            }
        }
        if (!hittat) {
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

        UserTV userList = new UserTV(userName, pswrd, level);
        users.add(userList);

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

    private static void readFileUserData(ArrayList<UserTV> users, File newPwd) {
        try {
            if (!newPwd.exists()) {
                if (!newPwd.createNewFile()) {
                    System.out.println("Kunde ej hitta eller skapa filen: " + newPwd.getName());
                    throw new Exception("Kunde inte hitta eller skapa filen.");
                }
            }
            Scanner readFile = new Scanner(newPwd);
            while (readFile.hasNextLine()) {
                String row = readFile.nextLine();
                users.add(new UserTV(row));
            }
            readFile.close();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }


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
        return data.toArray(new String[0]); //Förstår inte denna del
    }

    //försöker göra ny funktion nedan (userSaveRegistry(
    /*
    private static void saveUserData(userTV user) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.pwd", true)));
            out.println(user.getUserName() + ";" + user.getPassword() + ";" + user.getCredentials());
            out.close();
        } catch (Exception ignored) {

        }
    }

     */
    private static boolean userSaveRegistry(File newPwd, ArrayList<UserTV> users) {
        try {
            FileWriter writer = new FileWriter(newPwd);
            for (int i = 0; i < users.size(); i++) {
                UserTV p = users.get(i);
                writer.write(p.getUserName() + ";" + p.getPassword() + ";" + p.getCredentials() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //gör ett försök att ersätta checkUser
 /*   private static void logCheck(String anvandarnamn, String passwd, ArrayList<userTV> users) {
        for (int i = 0; i < users.size(); i++) {
            if (anvandarnamn.equals(users.get(i).userName)) {
                if (passwd.equals(users.get(i).password)) {
                    System.out.println("Välkommen " + users.get(i).userName);
                    logIn();
                } else System.out.println("Fel uppgifter. Var vänlig försök igen.");
            }


        }
    }

  */

    private static boolean checkUser(String username, String password)  {
        //Öppna och läsa från fil
        boolean found = false;
        for (String user : getUsersFromFile()) {
            String[] values = user.split(";");

            if (username.equals(values[0]) &&
                    password.equals(values[1])) {
                found = true;
                System.out.println("Välkommen, " + values[2] + "!");
                //sätt variabel user, annars fel uppgifter som nedan.
                userTV = new UserTV(values[0], values[1], values[2]);
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

    private static void viewUsers(ArrayList<UserTV> users) {
        System.out.println("Användare: " + users.size());
        String format = "%15s %15s %15s\n";
        System.out.format(format, "Användarnamn", "Lösenord", "Behörighet");
        Collections.sort(users, ((o1, o2) -> o1.getUserName().compareTo(o2.getUserName())));
        for (int i = 0; i < users.size(); i++) {
            System.out.format(
                    format,
                    users.get(i).getUserName(), //namn, efternamn, poäng,
                    users.get(i).getPassword(),
                    users.get(i).getCredentials());

        }
    }

    /* private static void userPrint() {
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

     */
    private static void menuPrint() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ": " + menuItems.get(i));
        }
    }

    private static void addMenuItems() {
        switch (userTV.getCredentials()) {

            case USER:
                menuItems.add("Visa Programlista");
                menuItems.add("Sök efter program");
                menuItems.add("Avsluta");
                break;
            case NONE:
                menuItems.add("Avsluta");
                break;
            case ADMIN:
                menuItems.add("Visa Programlista");
                menuItems.add("Sök efter program");
                menuItems.add("Lägg till program");
                menuItems.add("Ta bort program");
                menuItems.add("Avsluta");
                break;
            case SUPERUSER:
                menuItems.add("Visa Programlista");
                menuItems.add("Sök efter program");
                menuItems.add("Lägg till program");
                menuItems.add("Ta bort program");
                menuItems.add("Lista användare");
                menuItems.add("Lägg till användare");
                menuItems.add("Ta bort användare");
                menuItems.add("Avsluta");
            break;

        }
    }
}