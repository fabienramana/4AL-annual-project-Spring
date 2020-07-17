package al.esgi.annualProject.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;
    
    @NotNull
    @Column(name="label", nullable = false)
    private String label;

    @NotNull
    @Column(name="api_category_id")
    private Integer apiCategoryId;
    
    public Category(){
    }
    
    public Category(String label, Integer apiCategoryId){
        this.label = label;
        this.apiCategoryId = apiCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getApiCategoryId() {
        return apiCategoryId;
    }

    public void setApiCategoryId(Integer apiCategoryId) {
        this.apiCategoryId = apiCategoryId;
    }
}
