package com.marvel.demo.dto;

import java.util.ArrayList;

public class StoryList {

    private Integer avaliable;
    private Integer returned;
    private String collectionURI;
    private ArrayList<StorySummary> items;

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

    public ArrayList<StorySummary> getItems() {
        return items;
    }

    public void setItems(ArrayList<StorySummary> items) {
        this.items = items;
    }
}
