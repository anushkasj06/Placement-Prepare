public class Painter_Paritions {
    public int minTime(int[] boards, int k) {
        int low = findmax(boards); // minimum time (largest board)
        int high = findsum(boards); // maximum time (sum of all boards)
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (canPaint(boards, k, mid)) {
                high = mid; // try for a smaller maximum time
            } else {
                low = mid + 1; // increase the maximum time
            }
        }
        return low; // return the minimum time required
    }

    private int findmax(int[] boards) {
        int max = Integer.MIN_VALUE;
        for (int board : boards) {
            max = Math.max(max, board);
        }
        return max; // maximum board length
    }

    private int findsum(int[] boards) {
        int sum = 0;
        for (int board : boards) {
            sum += board; // total length of all boards
        }
        return sum; // total length of all boards
    }

    private boolean canPaint(int[] boards, int k, int maxTime) {
        int painters = 1; // start with one painter
        int currentSum = 0; // current sum of the board lengths

        for (int board : boards) {
            if (currentSum + board > maxTime) {
                painters++; // need a new painter
                currentSum = board; // start new painter with this board
                if (painters > k) return false; // too many painters needed
            } else {
                currentSum += board; // add to current painter's work
            }
        }
        return true; // successful painting within the limit
    }
}
