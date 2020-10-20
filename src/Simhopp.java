import java.util.Scanner;

public class Simhopp {
    public static void main(String args[]) {
        System.out.println("Ange antal domare:");
        Scanner sc = new Scanner(System.in);
        int antal = sc.nextInt(); //5

        int[] points = new int[antal];

        for (int i = 0; i < points.length; i++) {
            System.out.print("Domare " + (i + 1) + " ange poäng: ");
            points[i] = sc.nextInt();
        }
        System.out.println("Poäng: " + rakna (points));
    }


private static double rakna (int [] allaTal) {
    int sum = 0;
    for (int i = 0; i < allaTal.length; i = i + 1) {
        sum = sum + allaTal[i];
    }
    double r = sum / (allaTal.length * 1.0);
    return r;
    }

}