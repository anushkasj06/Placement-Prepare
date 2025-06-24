import java.util.*;

public class GenerateBinary{
    public static void main(String[] args) {
        int n = 3;
        GenerateBinarystring(n,"");
    }
    public static void GenerateBinarystring(int n,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        GenerateBinarystring(n-1,str+"0");
        GenerateBinarystring(n-1,str+"1");
    }

}