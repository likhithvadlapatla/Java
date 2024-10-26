package com.ge.service;

import com.ge.api.CategoryController;
import com.ge.model.Category;
import com.ge.repository.ICategoryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepo repo;

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    /*
        Different Contexts: The same log message (e.g., "Category created successfully") can appear in both places but with different contexts. In the service, it indicates successful creation from a business perspective. In the controller, it may serve as confirmation that the service call completed and the response is being returned.
        Separation of Concerns: The controller should handle the communication with the client, while the service handles business logic. Logging in both places can help isolate where an issue occurs—whether it's in handling the request/response (controller) or in processing the business logic (service).
     */

    @Override
    public Category createCategory(String name) {
        logger.info("Creating category with name: {}", name);
        Category category = new Category();
        category.setName(name);
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        try{
            Category savedCategory = repo.save(category);
            logger.info("Category created successfully with ID: {}", savedCategory.getId());
            return savedCategory;
        }
        catch(Exception e){
            logger.error("Error occurred while creating category: {]", e.getMessage());
            throw e;
        }
    }

    public void updateCategory(Category category){
        logger.info("Updating category with ID: {}",category.getId());
        try{
            repo.updateCategory(category);
            logger.info("Category updated successfully with ID: {}",category.getId());
        }
        catch(Exception e){
            logger.error("Error occurred while updating category: {}",category.getId());
            throw e;
        }
    }

    @Override
    public void deleteCategory(Long categoryId){
        logger.info("Deleting category with ID: {}",categoryId);
        try{
            repo.deleteCategory(categoryId);
            logger.info("Category deleted successfully with ID: {}",categoryId);
        }
        catch(Exception e){
            logger.error("Error occurred while deleting category: {}",categoryId);
            throw e;
        }
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        return repo.findCategoryById(categoryId);
    }

    @Override
    public List<Category> findAllCategories() {
        return repo.findAll();
    }

    @Override
    public Category findCategoryByName(String name) {
        return repo.findCategoryByName(name);
    }
}
