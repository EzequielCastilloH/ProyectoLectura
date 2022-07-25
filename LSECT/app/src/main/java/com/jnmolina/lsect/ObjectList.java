package com.jnmolina.lsect;

public class ObjectList {
    private int idImage;
    private String phraseTitle, url;


    public ObjectList(int idImage, String phraseTitle, String url) {
        this.idImage = idImage;
        this.phraseTitle = phraseTitle;
        this.url = url;
    }

    public String getPhraseTitle() {
        return phraseTitle;
    }


    public int getIdImage() {
        return idImage;
    }

    public String getUrl() {
        return url;
    }
}