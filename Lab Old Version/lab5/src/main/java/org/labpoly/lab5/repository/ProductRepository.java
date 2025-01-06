package org.labpoly.lab5.repository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.labpoly.lab5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    int removeProductById(Integer id);

    Product findProductById(Integer id);

    List<Product> findProductByName(@Size(max = 50) @NotNull String name);
}