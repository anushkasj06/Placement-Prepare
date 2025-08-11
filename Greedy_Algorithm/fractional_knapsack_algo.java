package Greedy_Algorithm;
import java.util.*;

public class fractional_knapsack_algo {

    public class Item {
        int weight;
        double value;

        public Item(int weight, double value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public class itemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double ratioA = a.value / a.weight;
            double ratioB = b.value / b.weight;
            if(ratioA < ratioB) return 1;
            else if(ratioA > ratioB) return -1;
            else return 0;
        }
    }
    public double getMaxValue(int W, Item[] arr) {
        Arrays.sort(arr, new itemComparator());
        double totalValue = 0;
        for (Item item : arr) {
            if (W == 0) break;
            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                int remain = W;
                totalValue += ((double)item.value / item.weight)* remain;
                W = 0;
            }
        }
        return totalValue;
    }
}
