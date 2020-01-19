package com.marvel.demo.dto;

import java.util.ArrayList;

public class SeriesList {
    private Integer available;
    private Integer returned;
    private String collectionURI;
    private ArrayList<SeriesSummary> items;

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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

    public ArrayList<SeriesSummary> getItems() {
        return items;
    }

    public void setItems(ArrayList<SeriesSummary> items) {
        this.items = items;
    }
}
