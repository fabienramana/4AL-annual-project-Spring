package al.esgi.annualProject.service;

import al.esgi.annualProject.models.Category;
import al.esgi.annualProject.repository.CategoryRepository;
import al.esgi.annualProject.utils.DoRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public String apiKey = "e80ae4cad06b931beaa5b7f21ea45904";
    
    public Category addNewCategory(Category category){
        return categoryRepository.save(category);
    }
    
    public Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    
    public String getCategoriesFromApi() throws IOException, InterruptedException {
        DoRequest request = new DoRequest("https://api.themoviedb.org/3/genre/tv/list?api_key="+ apiKey + "&language=fr-FR");
        String response = request.getRequest();

        JSONObject json = new JSONObject(response);
        JSONArray results = json.getJSONArray("genres");
        StringBuilder str = new StringBuilder();
        Category category;
        for (Object o : results) {
            JSONObject result = (JSONObject) o;
            Integer categoryId = result.getInt("id");
            String label = result.getString("name");
            Optional<Category> categoryExists = categoryRepository.findByapiCategoryId(categoryId);
            Category a = categoryExists.orElse(null);
            if (a == null) {
                category = new Category(label, categoryId);
                categoryRepository.save(category);
            }
        }
        
        request = new DoRequest("https://api.themoviedb.org/3/genre/movie/list?api_key="+ apiKey + "&language=fr-FR");
        response = request.getRequest();

        json = new JSONObject(response);
        results = json.getJSONArray("genres");
        str = new StringBuilder();
        for (Object o : results) {
            JSONObject result = (JSONObject) o;
            Integer categoryId = result.getInt("id");
            String label = result.getString("name");
            Optional<Category> categoryExists = categoryRepository.findByapiCategoryId(categoryId);
            Category a = categoryExists.orElse(null);
            if (a == null) {
                category = new Category(label, categoryId);
                categoryRepository.save(category);
            }
        }
        return "categories saved";
    } 
}
