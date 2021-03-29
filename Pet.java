package API;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private int id;
    private int categoryId;
    private String categoryName;
    private String name;
    private List <String> photoUrls;
    // private List<Object> tagsId;
    //private List<Object> tagsName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryid() {
        return categoryId;
    }

    public void setCategoryid(int categoryid) {
        this.categoryId = categoryid;
    }

    private List <String> tags;

    public String getCategoryname() {
        return categoryName;
    }

    public void setCategoryname(String categoryname) {
        this.categoryName = categoryname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {

        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

}



