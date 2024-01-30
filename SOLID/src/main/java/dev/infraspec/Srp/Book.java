package dev.infraspec.Srp;

public class Book {
    private final String title;
    private final String author;
    private final int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return this.title + "\t" + this.author + "\t" + this.publishedYear;
    }

    public boolean hasSameTitleAs(String anotherTitle) {
        return (title.equals(anotherTitle));
    }
}