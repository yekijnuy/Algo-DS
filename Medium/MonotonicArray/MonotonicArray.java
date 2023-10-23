import java.util.*;

// Time: O(n)
// Space: O(1)
class Program {
    public static boolean isMonotonic(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isNonDecreasing = false;
            }

            if (array[i] > array[i - 1]) {
                isNonIncreasing = false;
            }
        }

        return isNonDecreasing || isNonIncreasing;
    }
}
