import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sony on 1/22/2017.
 * Given: array of integers
 * Output: all numbers wich have unique digits
 * Example: [1..20] => all except 11
 */
public class ShowNumbersWithUniqueDigits {
    public static int[] getNumbers(int[] array) {
        List<Integer> result = new LinkedList<>();
        for (int num : array) {
            if (isUniqueDigits(num))
                result.add(num);
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    private static boolean isUniqueDigits(int num) {
        if (num < 10)
            return true;

        int priorMod = num % 10;
        while (num > 0) {
            int mod = num < 10 ? num : num % 10;
            if (priorMod != mod)
                return true;

            priorMod = mod;
            num = num / 10;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,111,112,222};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(getNumbers(array)));
    }
}
