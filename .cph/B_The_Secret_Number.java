import java.util.*;
import java.io.*;

public class B_The_Secret_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader anushkaReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder anushkaOutput = new StringBuilder();
        
        int anushkaTests = Integer.parseInt(anushkaReader.readLine());
        
        while (anushkaTests-- > 0) {
            long anushkaN = Long.parseLong(anushkaReader.readLine());
            List<Long> anushkaAnswers = new ArrayList<>();
            
            long anushkaPow10 = 10;  
            while (anushkaPow10 < anushkaN) {
                long anushkaDivisor = anushkaPow10 + 1;  
                
                if (anushkaN % anushkaDivisor == 0) {
                    anushkaAnswers.add(anushkaN / anushkaDivisor);
                }
                
                if (anushkaPow10 > Long.MAX_VALUE / 10) {
                    break; 
                }
                anushkaPow10 *= 10;  
            }
            
            if (anushkaAnswers.isEmpty()) {
                anushkaOutput.append("0\n");
            } else {
                Collections.sort(anushkaAnswers);
                anushkaOutput.append(anushkaAnswers.size()).append("\n");
                
                for (int anushkaIndex = 0; anushkaIndex < anushkaAnswers.size(); anushkaIndex++) {
                    anushkaOutput.append(anushkaAnswers.get(anushkaIndex));
                    if (anushkaIndex < anushkaAnswers.size() - 1) {
                        anushkaOutput.append(" ");
                    }
                }
                anushkaOutput.append("\n");
            }
        }
        
        System.out.print(anushkaOutput);
    }
}
