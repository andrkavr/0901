import java.util.*;
public class PasswordString {
    public static void main(String args[]) {
        String SecretPinCode = "1234ads";

        System.out.print("Ange pin: ");
        Scanner tangentbord = new Scanner(System.in);
        String pinCode = tangentbord.nextLine();

        /*if (SecretPinCode.equals(pinCode)) {
            System.out.println("*** Välkommen ***");
        } else
            System.out.println("Felaktig pin. Inloggning misslyckades.");
        */
         if (pinCode.equals(SecretPinCode) == false){
                System.out.println("Fel lösenord. Systemet avslutas.");
                return;
                }
                System.out.print("*** Välkommen ***\n1. Lägg upp lön\n2. Lista löner\n3. Avsluta.");
                String val = tangentbord.nextLine();


    }
}