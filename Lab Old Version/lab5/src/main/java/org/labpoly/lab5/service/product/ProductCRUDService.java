package org.labpoly.lab5.service.product;

import org.labpoly.lab5.model.Product;

import java.util.List;

public interface ProductCRUDService {
    Product save(Product product);

    int delete(Integer id);

    Product findById(Integer id);

    List<Product> findAll();

    List<Product> findByName(String name);
}