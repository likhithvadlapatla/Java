package com.ge.api;

import com.ge.dto.CategoryDTO;
import com.ge.model.Category;
import com.ge.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@Tag(name = "Category Controller API's", description = "API's related to category.")
public class CategoryController {

    @Autowired
    private ICategoryService service;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @PostMapping("/createCategory")
    @Operation(summary = "POST Operation", description = "API will accept json category info and return category object.")
    Category createCategory(@RequestParam String name){
        logger.info("Received request to create category: {}",name);
        return service.createCategory(name);
    }

    @PutMapping("/updateCategory")
    @Operation(summary = "Put Operation",description = "API will accept json category info and it will update.")
    void updateCategory(@RequestBody CategoryDTO categoryDTO){
        logger.info("Received request to update the category: {}",categoryDTO.getName());
        Category category = service.findCategoryById(categoryDTO.getId());
        service.updateCategory(category);
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    @Operation(summary = "Delete Operation", description = "API will accept categoryId and will delete the respective category.")
    void deleteCategory(@PathVariable Long categoryId){
        logger.info("Received request to delete the category: {}",categoryId);
        service.deleteCategory(categoryId);
    }

    @GetMapping("/findById")
    @Operation(summary = "Get Operation", description = "API will accept categoryId and will find the respective category.")
    Category findCategoryById(@RequestParam Long categoryId){
        logger.info("Fetching category by Id: {}",categoryId);
        return service.findCategoryById(categoryId);
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get Operation", description = "API will find all the categories stored in the database.")
    List<Category> findAllCategories(){
        return service.findAllCategories();
    }

    @GetMapping("/findByName/{name}")
    @Operation(summary = "Get Operation", description = "API will accept category name and will find the respective category.")
    Category findCategoryByName(@PathVariable String name){
        return service.findCategoryByName(name);
    }
}
