package ua.opnu;
import java.util.Arrays;
import java.util.function.Predicate;
import java.lang.reflect.Array;

public class FilterUtility {

    public static <T> T[] filter(T[] input, Predicate<T> p) {

        @SuppressWarnings("unchecked")
        final T[] result = (T[]) Array.newInstance(
                input.getClass().getComponentType(), // Отримуємо фактичний тип T
                input.length
        );

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        // Повертаємо лише заповнену частину масиву
        return Arrays.copyOfRange(result, 0, counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {

        if (element == null) {
            for (T item : array) {
                if (item == null) return true;
            }
            return false;
        }

        for (T item : array) {
            if (element.equals(item)) {
                return true;
            }
        }

        return false;
    }
}