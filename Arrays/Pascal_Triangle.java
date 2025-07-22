import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pascal_Triangle {
    public int rthcthelemenetinpascal(int r, int c){
        int res = 1;
        for(int i=0;i<r;i++){
            res = res * (r - i);
            res = res / (i + 1);
        }
        return res;
    }

    public ArrayList<Integer> rthrowinpascal(int r){
        int ans =1;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<r + 1;i++){
           ans *= (r-i);
              ans /= i;
              res.add(ans);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp = rthrowinpascal(i);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        Pascal_Triangle pt = new Pascal_Triangle();
        int r = 4, c = 2; // Example row and column
        System.out.println("Element at row " + r + " and column " + c + ": " + pt.rthcthelemenetinpascal(r, c));

        ArrayList<Integer> row = pt.rthrowinpascal(r);
        System.out.println("Row " + r + " in Pascal's Triangle: " + row);

        ArrayList<ArrayList<Integer>> triangle = pt.generate(5);
        System.out.println("Pascal's Triangle with 5 rows: " + triangle);
    }
}

