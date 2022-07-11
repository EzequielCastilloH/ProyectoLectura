package com.jnmolina.lsect;

public class ObjectList {
    private int idImage;
    private String phraseTitle;


    public ObjectList (int idImage, String phraseTitle) {
        this.idImage = idImage;
        this.phraseTitle = phraseTitle;

    }

    public String getPhraseTitle() {
        return phraseTitle;
    }


    public int getIdImage() {
        return idImage;
    }
}