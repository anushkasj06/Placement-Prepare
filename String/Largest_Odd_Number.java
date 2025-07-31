package String;

public class Largest_Odd_Number {
    public String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Largest_Odd_Number lon = new Largest_Odd_Number();
        String input = "52";
        String output = lon.largestOddNumber(input);
        System.out.println(output); // Output: "5"
    }
}
