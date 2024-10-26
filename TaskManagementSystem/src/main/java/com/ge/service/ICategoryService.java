package com.ge.service;

import com.ge.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {

    Category createCategory(String name);
    void updateCategory(Category category);
    void deleteCategory(Long categoryId);
    Category findCategoryById(Long categoryId);
    List<Category> findAllCategories();
    Category findCategoryByName(String name);

}
