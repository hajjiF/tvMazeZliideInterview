package com.example.farouk.tvmazeforzliide.model.entity;

/**
 * Created by farouk on 03/06/2018.
 */

public class Image {
    /**
     * medium : http://static.tvmaze.com/uploads/images/medium_portrait/0/1.jpg
     * original : http://static.tvmaze.com/uploads/images/original_untouched/0/1.jpg
     */

    private String medium;
    private String original;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
