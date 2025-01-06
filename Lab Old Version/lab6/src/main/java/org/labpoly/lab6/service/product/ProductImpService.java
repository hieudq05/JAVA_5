package org.labpoly.lab6.service.product;

import org.labpoly.lab6.model.Product;
import org.labpoly.lab6.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpService implements ProductService {

    private final ProductRepository productRepository;

    public ProductImpService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CRUD

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findProductByPriceBetween(Double min, Double max) {
        return productRepository.findProductByPriceBetween(min, max);
    }

    // PAGINATION

    @Override
    public Page<Product> findProductsByNameLikeOnPage(String name, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepository.findProductByNameContains(name, pageable);
    }

    @Override
    public Page<Product> findAllProductsOnPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageable);
    }
}
