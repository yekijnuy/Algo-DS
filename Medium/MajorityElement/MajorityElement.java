import java.util.*;

class Program {
    public int majorityElement(int[] array) {
        int count = 0;
        int answer = array[0];

        for (int value : array) {
            if (count == 0) {
                answer = value;
            }

            if (value == answer) {
                count++;
            } else {
                count--;
            }
        }

        return answer;
    }
}
