

import java.util.Stack;

public class Asteriod_Collison {
    public int[] asteroidCollision(int[] arr) {
        if(arr.length<=1){
            return arr;
        }
        Stack<Integer> st = new Stack<>();
        for(int a:arr){
            if(a>0){
                st.push(a);
            }else{
                while(!st.isEmpty() && st.peek() >0  && st.peek() <-a){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(a);
                }
                if(st.peek()==-a){
                    st.pop();
                }
            }
        }

        int[] res = new int[st.size()];
        int i = st.size() - 1;

        while(!st.isEmpty()) {
            res[i--] = st.pop();
        }

        return res;
    }
}
