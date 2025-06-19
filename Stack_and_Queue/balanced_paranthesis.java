package Stack_and_Queue;
import java.util.Stack;

public class balanced_paranthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if(ch==')'){
                    if(stack.isEmpty()||stack.pop()!='('){
                        return false;
                    }
                }
                if(ch=='}'){
                    if(stack.isEmpty()||stack.pop()!='{'){
                        return false;
                    }
                }
                if(ch==']'){
                    if(stack.isEmpty()||stack.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
