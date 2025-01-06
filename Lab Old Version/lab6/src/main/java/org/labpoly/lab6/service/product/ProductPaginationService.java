package org.labpoly.lab6.service.product;

import org.labpoly.lab6.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductPaginationService {
    Page<Product> findProductsByNameLikeOnPage(String name, int page, int pageSize);

    Page<Product> findAllProductsOnPage(int page, int pageSize);
}
