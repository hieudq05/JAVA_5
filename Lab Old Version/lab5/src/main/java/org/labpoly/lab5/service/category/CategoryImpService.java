package org.labpoly.lab5.service.category;

import org.labpoly.lab5.model.Category;
import org.labpoly.lab5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryImpService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public int deleteById(String id) {
        return categoryRepository.removeCategoryById(id);
    }

    public Category findById(String id) {
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    public List<Category> findByNameLike(String name) {
        return categoryRepository.findCategoryByNameLike(name);
    }
}
