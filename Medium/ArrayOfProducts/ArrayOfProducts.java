import java.util.*;

// Time: O(n)
// Space: O(n)
class Program {
    public int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }
}
