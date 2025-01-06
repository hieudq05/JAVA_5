package org.labpoly.lab5.service.product;

import org.labpoly.lab5.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductPaginationService {
    Page<Product> getProductsOnPage(int page, int pageSize);
}
