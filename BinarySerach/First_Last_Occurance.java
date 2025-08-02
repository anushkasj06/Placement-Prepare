public class First_Last_Occurance {
    public int[] findFirstLastOccurrence(int[] arr, int target) {
        int first = lowerBound(arr, target);
        if(first == arr.length || arr[first] != target) {
            return new int[]{-1, -1}; // Target not found
        }
        int last = upperBound(arr, target) - 1; // Upper bound gives the index of the first element greater than target
        return new int[]{first, last};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int ans = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        int ans = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]> target) {
                ans = mid; // Update ans to the current mid
                right = mid; // Move right to mid to find a potentially smaller index
            } else {
                left = mid + 1; // Move left to mid + 1 to find a greater element
            }
        }
        return ans;
    }


    public int[] firstLastOcuuranceUsingBinarySearch(int[] arr, int target) {
        int first = firstBS(arr, target);
        if (first == -1) {
            return new int[]{-1, -1}; // Target not found
        }
        int last = lastBS(arr, target); // Upper bound gives the index of the first element greater than target
        return new int[]{first, last};
    }

    private int firstBS(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid; // Update ans to the current mid
                right = mid - 1; // Move right to mid - 1 to find a potentially smaller index
            } else if (arr[mid] < target) {
                left = mid + 1; // Move left to mid + 1 to find a greater element
            } else {
                right = mid - 1; // Move right to mid - 1 to find a smaller element
            }
        }
        return first; // This is the index of the first occurrence of target
    }

    public int lastBS(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid; // Update ans to the current mid
                left = mid + 1; // Move left to mid + 1 to find a potentially larger index
            } else if (arr[mid] < target) {
                left = mid + 1; // Move left to mid + 1 to find a greater element
            } else {
                right = mid - 1; // Move right to mid - 1 to find a smaller element
            }
        }
        return last; // This is the index of the last occurrence of target
    }


    public int CountOccuarnaceInArray(int[] arr, int target) {
        int first = firstBS(arr, target);
        if (first == -1) {
            return 0; // Target not found
        }
        int last = lastBS(arr, target);
        return last - first + 1; // Count is last index - first index + 1
    }
}
