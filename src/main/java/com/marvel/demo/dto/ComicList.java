package com.marvel.demo.dto;

import java.util.ArrayList;

public class ComicList {

    private Integer avaliable;
    private Integer returned;
    private String collectionURI;
    private ArrayList<ComicSummary> items;

    public Integer getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Integer avaliable) {
        this.avaliable = avaliable;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public ArrayList<ComicSummary> getItems() {
        return items;
    }

    public void setItems(ArrayList<ComicSummary> items) {
        this.items = items;
    }
}
