package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;

public class ProductTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Book1", 700, "Author1");
    Product smartphone = new Smartphone(2, "Iphone X", 60000, "Apple");

    @Test
    public void saveProducts() {
        repository.save(book);
        repository.save(smartphone);

        Product[] expected = {book, smartphone};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdProducts() {
        repository.save(book);
        repository.save(smartphone);

        repository.removeById(2);


        Product[] expected = {book};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByProducts() {
        manager.add(book);
        manager.add(smartphone);

        manager.searchBy("Iphone X");

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy(smartphone.getName());

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void addProducts() {
        manager.add(book);
        manager.add(smartphone);

        Product[] expected = {book, smartphone};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
