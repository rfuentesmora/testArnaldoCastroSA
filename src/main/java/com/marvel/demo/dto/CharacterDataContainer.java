package com.marvel.demo.dto;

import java.util.ArrayList;

public class CharacterDataContainer {

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private ArrayList<Character> results;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Character> getResults() {
        return results;
    }

    public void setResults(ArrayList<Character> results) {
        this.results = results;
    }
}
