package org.example.hometask2.task2;

import org.example.hometask2.task1.Student;

import java.util.HashSet;

public class BookCollection {
    private HashSet<Book> books;


    public BookCollection(HashSet<Book> books) {
        this.books = books;
    }

    public BookCollection() {
        books = new HashSet<>();
    }

    public void addBook(Book book) {
        this.books.add(book);

    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void removeBook(String name) {

        Book targetBook = null;

        for (Book book : books) {
            if (book.getName().equals(name)) {
                targetBook = book;
            }
        }
        if (targetBook != null) {
            books.remove(targetBook);
        } else {
            System.out.println("Book with name " + name + " is not found");
        }
    }

    int count = 0;
    public void checkBook(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Book with name: " + name + " was found");
        }
        else {
            System.out.println("Book with name: " + name + " wasn't found");
        }
    }
}
