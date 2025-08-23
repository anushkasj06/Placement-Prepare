import java.util.*;

public class A_Homework{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt()
            String a = sc.nextLine();
            int m = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt()
            String b = sc.nextLine();
            String c = sc.nextLine();

            StringBuilder valid = new StringBuilder();
            StringBuilder david = new StringBuilder();
            for(int i = 0; i < m; i++) {
                if(c.charAt(i) == 'D'){
                    david.append(b.charAt(i));
                } else {
                    valid.append(b.charAt(i));
                }
            }

            String result = valid.reverse().toString() + a + david.toString();
            System.out.println(result);
        }
        sc.close();
    }
}