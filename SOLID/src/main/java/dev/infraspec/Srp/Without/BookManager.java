package dev.infraspec.Srp.Without;

import dev.infraspec.Srp.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private final List<Book> bookList;
    private final List<Book> checkedoutBookList;
    private final String FILE_NAME = "BookList.txt";

    public BookManager() {
        bookList = fetchBooks();
        checkedoutBookList = new ArrayList<>();
    }

    private List<Book> fetchBooks() {
        try {
            String booksString = readFile(FILE_NAME);
            return parseBookFromString(booksString);
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    public boolean checkoutBook(String title) {
        int beforeCheckoutLength = checkedoutBookList.size();
        for (Book book : new ArrayList<>(bookList)) {
            addIfSameTitle(book, title);
        }
        return (beforeCheckoutLength != checkedoutBookList.size());
    }

    private void addIfSameTitle(Book book, String title) {
        if (book.hasSameTitleAs(title)) {
            checkedoutBookList.add(book);
            bookList.remove(book);
        }
    }

    private void removeIfSameTitle(Book book, String title) {
        if (book.hasSameTitleAs(title)) {
            checkedoutBookList.remove(book);
            bookList.add(book);
        }
    }

    public boolean returnBook(String title) {
        int beforeCheckoutLength = checkedoutBookList.size();
        for (Book book : new ArrayList<>(checkedoutBookList)) {
            removeIfSameTitle(book, title);
        }
        return (beforeCheckoutLength != checkedoutBookList.size());
    }

    public List<Book> parseBookFromString(String booksString) throws
            ArrayIndexOutOfBoundsException, NumberFormatException {

        List<Book> books = new ArrayList<>();
        String[] booksStringSplitByNewLine = booksString.split("\n");
        for (String bookString : booksStringSplitByNewLine) {
            String[] booksStringSplitByTab = bookString.split(",");

            String title = booksStringSplitByTab[0];
            String author = booksStringSplitByTab[1];
            String publishedYearString = booksStringSplitByTab[2];
            int publishedYear = Integer.parseInt(publishedYearString);
            Book book = new Book(title, author, publishedYear);

            books.add(book);
        }

        return books;
    }

    public String readFile(String name) throws FileNotFoundException {
        String path = getRelativePath(name);
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String book = scanner.nextLine();
                stringBuilder.append(book);
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString().trim();
    }

    private String getRelativePath(String fileName) {
        try {
            return getClass().getClassLoader().getResource(fileName).getFile();
        } catch (NullPointerException nullPointerException) {
            return "";
        }
    }
}
