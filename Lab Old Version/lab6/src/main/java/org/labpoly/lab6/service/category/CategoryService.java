package org.labpoly.lab6.service.category;

import org.labpoly.lab6.model.Category;
import org.labpoly.lab6.model.modelDTO.ReportByCategory;
import org.labpoly.lab6.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<ReportByCategory> reportByCategory() {
        return categoryRepository.reportByCategory();
    }
}
