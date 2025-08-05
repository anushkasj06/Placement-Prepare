public class Book_Allocation {
    public int maxBooks(int[] books, int m) {
        int n = books.length;
        if (n < m) return -1; // not enough books for each student

        int low = 0; // minimum pages
        int high = 0; // maximum pages
        for (int book : books) {
            high += book; // total pages
            low = Math.max(low, book); // at least one book must be assigned
        }

        while (low < high) {
            int mid = (low + high) / 2;
            if (canAllocate(books, m, mid)) {
                high = mid; // try for a smaller maximum
            } else {
                low = mid + 1; // increase the maximum
            }
        }
        return low; // low will be the minimum possible maximum pages
    }

    private boolean canAllocate(int[] books, int m, int max) {
        int students = 1; // start with one student
        int currentSum = 0; // current sum of pages assigned to the student

        for (int book : books) {
            if (currentSum + book > max) {
                students++; // need a new student
                currentSum = book; // assign this book to the new student
                if (students > m) return false; // too many students needed
            } else {
                currentSum += book; // add book to current student's allocation
            }
        }
        return true; // allocation successful within the limit
    }
}
