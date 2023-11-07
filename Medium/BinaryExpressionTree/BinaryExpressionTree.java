
/**
*
* Student tasks: implement tasks as specified in this file
*
* Note: BXT Represents a binary expression tree.
* BXT can build itself from a postorder expression.  
* It can evaluate and print itself. It also prints an inorder string and a preorder string.  
*/

import java.util.*;

class BXT {
    private TreeNode root;

    public BXT() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void buildTree(String str) {
        Stack<TreeNode> stack = new Stack<>();

        String[] tokens = str.split(" "); // Splitting the string by space
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(new TreeNode(token));
            } else {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                stack.push(new TreeNode(token, left, right));
            }
        }
        root = stack.pop();
    }

    public double evaluateTree() {
        // *** Student task ***
        /*
         * Do this recursively. If the node is an operator, recursively evaluate the
         * left child
         * and the right child, and return the result. Else the node is a number, so it
         * can
         * be converted into a double, and returned.
         *** Enter your code below ***
         */

        return evaluateTree(root);
    }

    private double evaluateTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (isNumeric(node.getData())) {
            return Double.parseDouble(node.getData());
        }

        double leftVal = evaluateTree(node.getLeft());
        double rightVal = evaluateTree(node.getRight());

        switch (node.getData()) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            case "%":
                return leftVal % rightVal;
        }
        return 0;
    }

    public String display() {// optional, it is not for grading
        // *** Student task ***
        /*
         * Display tree structure. Plese refer to GA2 if you need to refresh your
         * knowledge
         *** Enter your code below ***
         */
        return display(root, 0); // replace it with yours
    }

    private String display(TreeNode node, int level) {
        if (node == null)
            return "";
        String result = "";
        result += display(node.getRight(), level + 1);
        for (int i = 0; i < level; i++)
            result += "  ";
        result += node.getData() + "\n";
        result += display(node.getLeft(), level + 1);
        return result;
    }

    public String infix() {
        StringBuilder sb = new StringBuilder();
        infix(root, sb);
        return sb.toString().trim() + " ";
    }

    private void infix(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        if (node.getLeft() != null && node.getRight() != null) {
            infix(node.getLeft(), sb);
            sb.append(" ").append(node.getData()).append(" ");
            infix(node.getRight(), sb);
        } else {
            sb.append(node.getData());
        }
    }

    public String prefix() {
        StringBuilder sb = new StringBuilder();
        prefix(root, sb);
        return sb.toString().trim() + " ";
    }

    private void prefix(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.getData()).append(" ");
        prefix(node.getLeft(), sb);
        prefix(node.getRight(), sb);
    }

    public String postfix() {
        StringBuilder sb = new StringBuilder();
        postfix(root, sb);
        return sb.toString().trim() + " ";
    }

    private void postfix(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        postfix(node.getLeft(), sb);
        postfix(node.getRight(), sb);
        sb.append(node.getData()).append(" ");
    }

    // Utility function to check if the given string can be converted to numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}