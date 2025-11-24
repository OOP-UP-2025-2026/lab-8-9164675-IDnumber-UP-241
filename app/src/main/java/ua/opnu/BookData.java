package ua.opnu;

// BookData.java

class BookData implements Comparable<BookData> {

    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

    // Конструктор
    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    // Метод для обчислення рейтингу
    public double getRating() {
        return (reviews == 0) ? 0.0 : total / reviews;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f)", title, getRating());
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        // 1. Порівняння за рейтингом (Реверсний порядок: otherRating vs thisRating)
        if (thisRating != otherRating) {
            return Double.compare(otherRating, thisRating);
        }

        // 2. Порівняння за назвою (якщо рейтинги рівні)
        return this.title.compareTo(other.title);
    }
}