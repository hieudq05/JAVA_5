package org.labpoly.lab5.service.product;

import org.labpoly.lab5.model.Product;
import org.labpoly.lab5.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int delete(Integer id) {
        return productRepository.removeProductById(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findProductByName(name);
    }

    // FILTER

    @Override
    public List<Product> productsSortByPropAsc(String sortBy) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

    @Override
    public List<Product> productsSortByPropDesc(String sortBy) {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, sortBy));
    }

    // PAGINATION

    @Override
    public Page<Product> getProductsOnPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageable);
    }
}
