package org.labpoly.lab6.service.product;

import org.labpoly.lab6.model.Product;

import java.util.List;

public interface ProductCRUDService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findProductByPriceBetween(Double min, Double max);
}
