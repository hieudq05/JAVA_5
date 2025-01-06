package org.labpoly.lab6.repository;

import org.labpoly.lab6.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  Product findProductById(Integer id);

  List<Product> findProductByPriceBetween(Double priceAfter, Double priceBefore);

  Page<Product> findProductByNameContains(String name, Pageable pageable);
}