import java.util.Arrays;

public class SwapArrayElements {

    public static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {12, 27, 55, 18, 97, 125};
        System.out.println("Original array: " + Arrays.toString(arr));

        // swap elements at index 2 and index 4
        swap(arr, 2, 4);
        System.out.println("Array after swapping: " + Arrays.toString(arr));
    }
}
