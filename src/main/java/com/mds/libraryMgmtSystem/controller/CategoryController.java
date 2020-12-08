package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.entity.Category;
import com.mds.libraryMgmtSystem.pojo.CategoryPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.BookService;
import com.mds.libraryMgmtSystem.service.CategoryService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/categories")
    public BaseResponse getCategory(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "3000") Integer pageSize){
        List<Category> category;
        try{
            category= categoryService.getCategory(pageNo, pageSize);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, category, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/category/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Category category;
        try{
            category = categoryService.findById(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, category, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/search/category")
    public BaseResponse searchCategory(String type){
        List<Category> category;

        try{
            category = categoryService.searchCategory(type);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, category, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/category")
    public BaseResponse createCategory(@Validated @RequestBody Category category){
        try {
            category = categoryService.addCategory(category);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, category, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/category/{id}")
    public BaseResponse deleteCategory(@PathVariable Long id){
        try {
            categoryService.deleteCategory(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping (value = "/update/category")
    public BaseResponse updateCategory(@Validated @RequestBody CategoryPojo categoryPojo) {
        Category categories;

        try{
            Category category = categoryService.findById(categoryPojo.getId());

            if(category==null) {
                return null;
            }
            category.setType(categoryPojo.getType());
            category.setDescription(categoryPojo.getDescription());
            categories = categoryService.save(category);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, categories,GlobalConstant.Message.success_message);

    }
}
