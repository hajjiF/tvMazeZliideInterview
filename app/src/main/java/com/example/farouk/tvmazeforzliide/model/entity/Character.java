package com.example.farouk.tvmazeforzliide.model.entity;

/**
 * Created by farouk on 03/06/2018.
 */

public class Character {
    /**
     * id : 7
     * url : http://www.tvmaze.com/characters/7/under-the-dome-norrie-calvert-hill
     * name : Norrie Calvert-Hill
     * image : {"medium":"http://static.tvmaze.com/uploads/images/medium_portrait/0/793.jpg","original":"http://static.tvmaze.com/uploads/images/original_untouched/0/793.jpg"}
     */

    private int id;
    private String url;
    private String name;
    private Image image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image {
    }
}
