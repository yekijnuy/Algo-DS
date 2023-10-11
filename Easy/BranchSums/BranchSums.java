import java.util.*;

// Time: O(N)
// Space: O(N)

class Program {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        ArrayList<Integer> branchSumVals = new ArrayList<Integer>();
        Integer aggSum = 0;
        return branchSums(root, branchSumVals, aggSum);
    }

    public static List<Integer> branchSums(BinaryTree root, ArrayList<Integer> branchSumVals, Integer aggSum) {
        aggSum += root.value;
        if ((root.left == null) && (root.right == null)) {
            branchSumVals.add(aggSum);
            return branchSumVals;
        }
        // probably can get rid of the conditionals to make it cleaner
        if (root.left != null) {
            branchSums(root.left, branchSumVals, aggSum);
        }
        if (root.right != null) {
            branchSums(root.right, branchSumVals, aggSum);
        }
        return branchSumVals;
    }
}
