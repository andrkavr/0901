import java.util.*;
public class PasswordExempel {
    public static void main(String args[]){
        int secretPinCode = 1234;

        System.out.print("Ange pin: ");
        Scanner tangentbord = new Scanner(System.in);
        int pinCode = Integer.parseInt  (tangentbord.nextLine());
        if (pinCode != secretPinCode) {
            System.out.println("Felaktg pin. Inloggning misslyckades.");
            return;
        }

        System.out.println("*** Välkommen ***");
    }
}