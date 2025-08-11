package Greedy_Algorithm;

public class Paranthesis_Valid_chcek_greed {
    public boolean paranthesisValid(String s){
        if(s.length()==1){
            return false;
        }
        int open =0;
        int close =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                open++;
            }else{
                open--;
            }

            if(s.charAt(s.length()-i-1)==')' || s.charAt(s.length()-i-1)=='*'){
                close++;
            }else{
                close--;
            }
            if(open<0 || close<0){
                return false;
            }
        }
        return true;
    }



}
