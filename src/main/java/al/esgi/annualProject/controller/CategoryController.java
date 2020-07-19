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
    public String addNewCategory (@RequestBody Category category) {
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
       /* URL url = new URL("https://api.themoviedb.org/3/genre/tv/list?api_key="+ apiKey);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        String response = content.toString();

        //return response.body();
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

        url = new URL("https://api.themoviedb.org/3/genre/movie/list?api_key="+ apiKey);
        con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        status = con.getResponseCode();
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        inputLine = "";
        content = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        response = content.toString();

        //return response.body();
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
    } */
}
