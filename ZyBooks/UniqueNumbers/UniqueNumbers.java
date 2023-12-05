import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

public class LabProgram {

    // Print the numbers in array separated by a space
    public static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            System.out.printf("%d ", nums[i]);
        }
    }

    // Used in uniqueRandomInt(), printed in main()
    public static int retries;

    // Generate howMany unique random ints from 0 to maxNum using randGen
    public static int[] uniqueRandomInts(int howMany, int maxNum) {
        int i = 0;
        int nextRand;
        retries = 0; // Initialize static variable
        Random randGen = new Random(29); // Random number generator with seed 29

        int[] nums = new int[howMany];
        HashSet<Integer> alreadySeen = new HashSet<Integer>();

        while (i < howMany) {
            nextRand = randGen.nextInt(maxNum);

            if (!alreadySeen.contains(nextRand)) {
                nums[i] = nextRand;
                alreadySeen.add(nextRand);
                i++;
            } else {
                retries++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int howMany = scnr.nextInt();
        int maxNum = scnr.nextInt();

        int[] uniqueInts = uniqueRandomInts(howMany, maxNum);
        printNums(uniqueInts);
        System.out.printf("  [%d retries]\n", retries); // Print static variable here
    }
}
