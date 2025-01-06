package org.labpoly.lab6.repository;

import org.labpoly.lab6.model.Category;
import org.labpoly.lab6.model.modelDTO.ReportByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT new org.labpoly.lab6.model.modelDTO.ReportByCategory(p.category.name, SUM(p.price), COUNT(p))" +
            "FROM Product p GROUP BY p.category.id, p.category.name ORDER BY SUM(p.price) DESC")
    List<ReportByCategory> reportByCategory();
}