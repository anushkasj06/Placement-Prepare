package String;

public class REverse_Word_in_String {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        REverse_Word_in_String reverser = new REverse_Word_in_String();
        String input = "Hello World";
        String output = reverser.reverseWords(input);
        System.out.println(output);
    }
}
