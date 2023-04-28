import java.util.*;
import java.util.function.Function;

public class PalindromeCounter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("civic","radar", "refer", "deified", "example", "kayak");
        int palindromeCount = countPalindromes(words, Function.identity());
        System.out.println("Number of palindromes in the list: " + palindromeCount);
    }

    public static <T> int countPalindromes(Collection<T> collection, Function<T, String> propertyGetter) {
        int count = 0;
        for (T element : collection) {
            String property = propertyGetter.apply(element);
            if (property != null && property.equals(new StringBuilder(property).reverse().toString())) {
                count++;
            }
        }
        return count;
    }
}

