package Stack_and_Queue;

import java.util.Stack;

public class Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        for(int i= (2*n)-1; i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }

            if(i<n){
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return res;
    }

    public static void main(String[] args) {
        Next_Greater_Element_II obj = new Next_Greater_Element_II();
        int[] nums = {1,2,1};
        int[] result = obj.nextGreaterElements(nums);
        for(int num : result){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
