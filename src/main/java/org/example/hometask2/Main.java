package org.example.hometask2;

import org.example.hometask2.task1.Student;
import org.example.hometask2.task1.StudentManager;
import org.example.hometask2.task2.Book;
import org.example.hometask2.task2.BookCollection;
import org.example.hometask2.task3.PriceList;
import org.example.hometask2.task3.Product;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John Karitsky", "5362882");
        System.out.println(student1.toString());

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);

        studentManager.removeStudent("82");


        Book book1 = new Book("Необычайно умные создания", "Шелби ван Пелт");
        Book book2 = new Book("Чагин", "Евгений Водолазкин");

        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(book1);
        bookCollection.addBook(book2);

        bookCollection.checkBook("Необычайно умные создания");

        Product product1 = new Product("tomato", 0.99);
        Product product2 = new Product("banana", 1.99);
        Product product3 = new Product("milk", 1.32);

        PriceList priceList1 = new PriceList();
        priceList1.addPriceProduct(product1.getName(), product1.getPrice());
        priceList1.addPriceProduct(product2.getName(), product2.getPrice());
        priceList1.addPriceProduct(product3.getName(), product3.getPrice());

        priceList1.changeProductPrice(product2.getName(), 1.55);

        priceList1.getProductPrice(product2.getName());
    }
}
