package ua.opnu;

public class MyOptional<T> {

    private final T value;
    private final boolean present;

    // 1. Конструктор без параметрів (порожній)
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // 2. Конструктор з параметром (зі значенням)
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null. Використовуйте конструктор без параметрів для порожнього стану.");
        }

        this.value = value;
        this.present = true;
    }

    // 3. Метод boolean isPresent()
    public boolean isPresent() {
        return present;
    }

    // 4. Метод boolean isEmpty()
    public boolean isEmpty() {
        return !present;
    }

    // 5. Метод T get()
    public T get() {
        if (!present) {
            throw new IllegalStateException("Спроба отримати значення з порожнього MyOptional.");
        }
        return value;
    }

    // 6. Метод T orElse(T defaultValue)
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    // 7. Метод toString()
    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}