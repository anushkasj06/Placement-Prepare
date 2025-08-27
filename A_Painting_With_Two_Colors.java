import java.util.*;

public class A_Painting_With_Two_Colors {
    public static void main(String[] anuArgs) {
        Scanner anuScanner = new Scanner(System.in);
        int anuT = anuScanner.nextInt();
        while (anuT-- > 0) {
            long anuN = anuScanner.nextLong();
            long anuA = anuScanner.nextLong();
            long anuB = anuScanner.nextLong();

            if ((anuN % 2) != (anuB % 2)) {
                System.out.println("NO");
            } else if (anuA <= anuB) {
                System.out.println("YES");
            } else if ((anuN % 2) == (anuA % 2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        anuScanner.close();
    }
}
