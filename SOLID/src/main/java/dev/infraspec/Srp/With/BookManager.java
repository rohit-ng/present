package dev.infraspec.Srp.With;

import dev.infraspec.Srp.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final List<Book> bookList;
    private final List<Book> checkedoutBookList;
    private final String FILE_NAME = "BookList.txt";

    public BookManager() {
        bookList = fetchBooks();
        checkedoutBookList = new ArrayList<>();
    }

    private List<Book> fetchBooks() {
        FileParser fileParser = new FileParser();

        try {
            String booksString = fileParser.readFile(FILE_NAME);
            return fileParser.parseBookFromString(booksString);
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
}