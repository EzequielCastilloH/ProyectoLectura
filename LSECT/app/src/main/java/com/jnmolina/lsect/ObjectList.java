package com.jnmolina.lsect;

public class ObjectList {
    private int idImage;
    private String phraseTitle, url, phraseClass;


    public ObjectList(int idImage, String phraseTitle, String url, String phraseClass) {
        this.idImage = idImage;
        this.phraseTitle = phraseTitle;
        this.url = url;
        this.phraseClass = phraseClass;
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

    public String getPhraseClass(){ return phraseClass; }
}