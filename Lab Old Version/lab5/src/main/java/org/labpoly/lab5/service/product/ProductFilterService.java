package org.labpoly.lab5.service.product;

import org.labpoly.lab5.model.Product;

import java.util.List;

public interface ProductFilterService {
    List<Product> productsSortByPropAsc(String sortBy);

    List<Product> productsSortByPropDesc(String sortBy);
}
