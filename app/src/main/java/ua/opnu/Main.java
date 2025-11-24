package ua.opnu;

// Main.java

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n 1. MyOptional<T>");

        // 1. Порожнє значення
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println("Порожній MyOptional: " + middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає по-батькові"));

        // 2. Заповнене значення
        MyOptional<String> username = new MyOptional<>("admin_user");
        System.out.println("Заповнений MyOptional: " + username);
        System.out.println("get(): " + username.get());

        // 3. Перевірка get() на порожньому об'єкті
        try {
            System.out.print("Виклик get() на порожньому: ");
            middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевірка конструктора на null
        try {
            System.out.print("Спроба створити з null: ");
            new MyOptional<String>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        System.out.println("\n 2. BookData (Comparable)");

        BookData bookA = new BookData("Книга A (Низький)", "Автор", 10, 80.0); // Рейтинг 8.0
        BookData bookB = new BookData("Книга B (Високий)", "Автор", 10, 95.0); // Рейтинг 9.5
        BookData bookC = new BookData("Книга C (Рівний)", "Автор", 5, 47.5);   // Рейтинг 9.5

        List<BookData> books = Arrays.asList(bookA, bookB, bookC);
        System.out.println("До сортування: " + books);

        // Сортування: книга з вищим рейтингом має бути першою
        Collections.sort(books);
        System.out.println("Після сортування:");
        System.out.println("(B=9.5, C=9.5, A=8.0): " + books);

        System.out.println("\n 3. Узагальнений Printer<T>");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.print("Масив Integer: ");
        myPrinter.printArray(intArray);

        System.out.print("Масив String: ");
        myPrinter.printArray(stringArray);

        System.out.println("\n 4. Узагальнений filter<T>");

        // Фільтр для String (довжина > 5)
        Predicate<String> longString = s -> s.length() > 5;
        String[] words = {"apple", "banana", "kiwi", "grapefruit", "fig"};
        String[] filteredWords = FilterUtility.filter(words, longString);
        System.out.println("Слова > 5 символів: " + Arrays.toString(filteredWords));

        System.out.println("\n 5. Узагальнений contains<T, V>");

        Integer[] numbers = {10, 20, 30, 40};
        System.out.println("Масив: " + Arrays.toString(numbers));

        // T=Integer (implements Comparable), V=Integer
        System.out.println("Масив містить 30? " + FilterUtility.contains(numbers, 30)); // true
        System.out.println("Масив містить 50? " + FilterUtility.contains(numbers, 50)); // false

        System.out.println("\n 6. GenericTwoTuple & GenericThreeTuple");

        // GenericTwoTuple (String, Double)
        GenericTwoTuple<String, Double> personData =
                new GenericTwoTuple<>("Alice", 175.5);
        System.out.println("TwoTuple (Ім'я, Зріст): " + personData);
        System.out.println("Тип first: " + personData.first.getClass().getSimpleName()); // String

        // GenericThreeTuple (Student, Integer, Boolean)
        GenericThreeTuple<BookData, Integer, Boolean> bookStats =
                new GenericThreeTuple<>(bookB, 2024, true);
        System.out.println("ThreeTuple (Книга, Рік, Чи бестселер): " + bookStats);
        System.out.println("Рік: " + bookStats.getSecond()); // 2024
    }
}