import java.util.*;

// Time: O(n)
// Space: O(d), d is the depth of the lists within the initial list
class Program {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        int multiplier = 1;
        return productSumHelper(array, multiplier);
    }

    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object el : array) {
            if (el instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> ls = (ArrayList<Object>) el;
                sum += productSumHelper(ls, multiplier + 1);
            } else {
                sum += (int) el;
            }
        }
        return sum * multiplier;
    }
}
