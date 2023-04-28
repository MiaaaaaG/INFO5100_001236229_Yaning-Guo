import java.util.Arrays;
import java.util.List;

public class MaximalElement {
    public static <T extends Comparable<? super T>> T findMax(List<? extends T> list, int start, int end) {
        T max = list.get(start);
        for (int i = start + 1; i < end; i++) {
            T current = list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(17, 52, 117, 25, 44);
        int max = findMax(numbers, 1, 4);
        System.out.println("Maximal element in the list is: " + max);
    }
}

