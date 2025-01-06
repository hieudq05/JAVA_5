package org.labpoly.lab5.repository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.labpoly.lab5.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> , JpaSpecificationExecutor<Category> {

  @Transactional
  int removeCategoryById(@Size(max = 4) String id);

  Category findCategoryById(@Size(max = 4) String id);

  List<Category> findCategoryByName(@Size(max = 50) @NotNull String name);

  List<Category> findCategoryByNameLike(@Size(max = 50) @NotNull String name);
}