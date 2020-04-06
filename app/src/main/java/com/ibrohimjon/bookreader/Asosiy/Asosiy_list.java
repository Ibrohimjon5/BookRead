package com.ibrohimjon.bookreader.Asosiy;

public class Asosiy_list {

    private String Id;
    private String Nomi;
    private String Category;
    private String Description;
    private String Image_url;

    public Asosiy_list(String id, String nomi, String category, String description, String image_url) {
        Id = id;
        Nomi = nomi;
        Category = category;
        Description = description;
        Image_url = image_url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNomi() {
        return Nomi;
    }

    public void setNomi(String nomi) {
        Nomi = nomi;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage_url() {
        return Image_url;
    }

    public void setImage_url(String image_url) {
        Image_url = image_url;
    }
}
