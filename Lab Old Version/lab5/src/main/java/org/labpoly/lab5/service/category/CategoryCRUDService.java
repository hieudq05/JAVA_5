package org.labpoly.lab5.service.category;

import org.labpoly.lab5.model.Category;

import java.util.List;

public interface CategoryCRUDService {
    Category save(Category category);

    int deleteById(String id);

    Category findById(String id);

    List<Category> findAll();

    List<Category> findByName(String name);

    List<Category> findByNameLike(String name);
}
