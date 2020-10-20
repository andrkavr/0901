import java.util.*;

public class Intro {
    public static void main(String[] args) {
        Scanner tangentbord = new Scanner (System.in);

        System.out.print("Vad heter du? ");
        String name = tangentbord.nextLine();



        System.out.println("Hej " + name);

        tangentbord.nextLine();
    }
}