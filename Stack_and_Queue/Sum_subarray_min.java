package Stack_and_Queue;

import java.util.Stack;

public class Sum_subarray_min {
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        long total = 0;
        int mod = 1000000007;

        for(int i=0;i<n;i++){
            int left = i- pse[i];
            int right = nse[i] -i;
            total = (total + (left* right*arr[i]* 1L)%mod)%mod;
        }
        return total;
    }

    public static int[] findnse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            } 
            if(stack.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = stack.peek();
            }
        }
        return nse;
    }

    public static int[] findpse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
            Sum_subarray_min obj = new Sum_subarray_min();
            int[] arr = {3,1,2,4};
            long result = obj.sumSubarrayMins(arr);
            System.out.println(result);
    }
}
