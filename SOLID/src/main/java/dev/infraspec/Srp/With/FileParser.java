package dev.infraspec.Srp.With;

import dev.infraspec.Srp.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
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