package ru.netology;

import ru.netology.products.Product;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;

    }

    // добавьте необходимые поля, конструкторы и методы


    public void add(Product product) {
        repository.save(product);


    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        Product[] tmp = new Product[result.length + 1];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                tmp[tmp.length - 1] = product;
                // "добавляем в конец" массива result продукт product
            }
        }
        result = tmp;
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}