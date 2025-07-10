package service;

import model.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public Library() {
        books.add(new Book("Legens of Markov", "Georghy Garpov", "romatic", 2018));
        books.add(new Book("Legens of Markov 2", "Georghy Garpov", "romatic", 2022));
        books.add(new Book("The Silent Echo", "Emily Bronston", "drama", 2015));
        books.add(new Book("Tuantum Paradox", "Raymond K. Sterling", "sci-fi", 2020));
        books.add(new Book("Thispers in the Dark", "Clara Vanguard", "horror", 2019));
        books.add(new Book("The Crimson Heirloom", "Diana Montclair", "historical", 2017));
        books.add(new Book("Neon Shadows", "Maxwell Byte", "cyberpunk", 2022));
    }

    public void addBook(Book book) {
        if (isBookExists(book)) return;
        books.add(book);
        printMessage("Book add successfully");
    }

    private void printMessage(String msg) {
        System.out.println(msg);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.title().equals(title));
    }
    @Deprecated
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> StringUtils.containsAny(book.title(), title))
                .collect(Collectors.toList());
    }

    public List<Book> deepSearch(String[] bookData){
        return books.stream()
                .filter(book -> StringUtils.containsAny(book.toString(),bookData))
                .toList();
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    private boolean isBookExists(Book book) {
        if (books.contains(book)) {
            printMessage("Oops.. This book already exists");
            return true;
        }
        return false;
    }

}