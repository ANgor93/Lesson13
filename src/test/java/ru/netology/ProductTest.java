package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;

public class ProductTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Book1", 700, "Author1");
    Product book2 = new Book(23, "Book2", 700, "Author2");
    Product book3 = new Book(44, "Book3", 700, "Author3");
    Product book4 = new Book(11, "Book4", 700, "Author4");
    Product book5 = new Book(12, "Book5", 700, "Author5");
    Product smartphone = new Smartphone(2, "Iphone X", 60000, "Apple");

    @Test
    public void saveFewProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);

        Product[] expected = {book1, book2, book3, book4, smartphone};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdProducts() {
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);

        repository.removeById(2);


        Product[] expected = {book2, book3, book4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByFewProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);


        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = manager.searchBy("Book");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByOneProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);


        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("X");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByNoneProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone);


        Product[] expected = {};
        Product[] actual = manager.searchBy("ball");

        Assertions.assertArrayEquals(expected, actual);
    }
}

