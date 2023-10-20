import java.util.*;

// Time: O(n)
// Space: O(h)
class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {

        return evaluateExpressionTree(tree, 0);

    }

    public int evaluateExpressionTree(BinaryTree tree, int aggr) {
        if (tree.left == null && tree.right == null) {
            return tree.value;
        }
        if (tree.value == -1) {
            int opSum = (evaluateExpressionTree(tree.left) + evaluateExpressionTree(tree.right));
            aggr += opSum;
        }
        if (tree.value == -2) {
            int opSum = (evaluateExpressionTree(tree.left) - evaluateExpressionTree(tree.right));
            aggr += opSum;
        }
        if (tree.value == -3) {
            int opSum = (evaluateExpressionTree(tree.left) / evaluateExpressionTree(tree.right));
            aggr += opSum;
        }
        if (tree.value == -4) {
            int opSum = (evaluateExpressionTree(tree.left) * evaluateExpressionTree(tree.right));
            aggr += opSum;
        }
        return aggr;
    }
}

// Time: O(n)
// Space: O(h)
class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree.value >= 0) {
            return tree.value;
        }

        int leftValue = evaluateExpressionTree(tree.left);
        int rightValue = evaluateExpressionTree(tree.right);

        if (tree.value == -1) {
            return leftValue + rightValue;
        } else if (tree.value == -2) {
            return leftValue - rightValue;
        } else if (tree.value == -3) {
            return leftValue / rightValue;
        }

        return leftValue * rightValue;
    }
}