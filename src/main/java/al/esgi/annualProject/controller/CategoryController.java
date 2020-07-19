package al.esgi.annualProject.controller;

import al.esgi.annualProject.models.Category;
import al.esgi.annualProject.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path="/category")
public class CategoryController {
    CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public Category addNewCategory (@RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path="/get-api")
    public String getCategoriesFromApi() throws IOException, InterruptedException {
        return categoryService.getCategoriesFromApi();
    }
}
