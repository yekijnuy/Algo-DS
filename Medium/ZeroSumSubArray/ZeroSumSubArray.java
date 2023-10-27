import java.util.*;

// Time: O(n)
// Space: O(1)
// Using logic, we know that 2 subsets have the same sum, means one must have had 0;
class Program {
    public boolean zeroSumSubarray(int[] nums) {
        HashSet<Integer> sums = new HashSet<Integer>();
        sums.add(0);
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (sums.contains(currentSum)) {
                return true;
            }
            sums.add(currentSum);
        }
        return false;
    }
}
