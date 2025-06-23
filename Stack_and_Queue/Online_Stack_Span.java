import java.util.Stack;

class Pair<K, V> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Online_Stack_Span {
    Stack<Pair<Integer, Integer>> stack;
    int idx;

    public Online_Stack_Span() {
        stack = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx = idx + 1;
        while (!stack.isEmpty() && stack.peek().value <= price) {
            stack.pop();            
        }
        int ans = idx - (stack.isEmpty() ? -1 : stack.peek().key);
        stack.push(new Pair(price, idx));
        return ans;
    }

    public static void main(String[] args) {
        Online_Stack_Span obj = new Online_Stack_Span();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.print(obj.next(price) + " ");
        }
        System.out.println();
    }
}
