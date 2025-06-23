public class Number_of_Recent_Call {
    private static final int[] r = new int[10000];
    private int s;
    private int e;
    public Number_of_Recent_Call() {
        s =0;
        e=0;
    }
    
    public int ping(int t) {
        while(s<e && (t-r[s]>3000)){
            s++;
        }
        r[e++] = t;
        return e -s;
    }
}
