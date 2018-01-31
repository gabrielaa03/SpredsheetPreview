package com.gabriela.googlespreadsheetpreview.model.data_models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {
    private ID id;
    private Updated updated;
    private Title title;
    private List<Entry> entry;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Updated getUpdated() {
        return updated;
    }

    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
