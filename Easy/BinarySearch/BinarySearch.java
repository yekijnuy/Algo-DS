import java.util.*;

// Time: O(log(n))
// Space: O(1) 
class Program {
    public static int binarySearch(int[] array, int target) {
        int lowPt = 0;
        int highPt = array.length - 1;

        while (lowPt <= highPt) {
            int midpoint = (lowPt + highPt) / 2;
            if (array[midpoint] == target) {
                return midpoint;
            } else if (target < array[midpoint]) {
                highPt = midpoint - 1;
            } else {
                lowPt = midpoint + 1;
            }
        }
        return -1;
    }
}

// Time: O(log(n))
// Space: O(log(n))
class Program {
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int potentialMatch = array[middle];

        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearch(array, target, left, middle - 1);
        } else {
            return binarySearch(array, target, middle + 1, right);
        }
    }
}
