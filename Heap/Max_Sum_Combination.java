package Heap;
import java.util.*;

public class Max_Sum_Combination {
    public class Node{
        int sum;
        int i;
        int j;
        public Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
    public List<Integer> maxSumCombination(int[] a, int[] b, int k) {
        if (a == null || b == null || k <= 0 || a.length == 0 || b.length == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.sum, x.sum));
        Set<String> seen = new HashSet<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int i = a.length - 1;
        int j = b.length - 1;

        pq.offer(new Node(a[i] + b[j], i, j));
        seen.add(i + "," + j);

        List<Integer> result = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            Node current = pq.poll();
            result.add(current.sum);

            i = current.i;
            j = current.j;

            if(current.i-1>=0){
                String key = (current.i - 1) + "," + current.j;
                if(!seen.contains(key)) {
                    pq.offer(new Node(a[current.i - 1] + b[current.j], current.i - 1, current.j));
                    seen.add(key);
                }
            }
            if(current.j-1>=0){
                String key = current.i + "," + (current.j - 1);
                if(!seen.contains(key)) {
                    pq.offer(new Node(a[current.i] + b[current.j - 1], current.i, current.j - 1));
                    seen.add(key);
                }
            }
        }

        return result;
    }
}
