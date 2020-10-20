import java.util.*;

public class Addera {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.out.print("Tre parametrar behöver anges. Exempelvis: 2 + 3");
        }
       else {
            calculate(args);
        }
    }

    public static void calculate (String args[]){
        switch (args[1]){
            case "+":
                System.out.println(Double.parseDouble(args[0]) +
                        Double.parseDouble(args[2]));
                break;
            case "-":
                System.out.println(Double.parseDouble(args[0]) -
                        Double.parseDouble(args[2]));
                break;
            case "/":
                System.out.println(Double.parseDouble(args[0]) /
                        Double.parseDouble(args[2]));
                break;
            case "*":
                System.out.println(Double.parseDouble(args[0]) *
                        Double.parseDouble(args[2]));
            default:
                System.out.println("Räknesätt ej definierat");
        }
    }
}