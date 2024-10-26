package com.ge.repository;

import com.ge.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepo extends JpaRepository<Category, Long> {
    public Category findCategoryById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.name=:#{#category.name} WHERE c.id=:#{#category.id}")
    void updateCategory(Category category);

    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c.id=:categoryId")
    void deleteCategory(Long categoryId);

    Category findCategoryByName(String name);
}
