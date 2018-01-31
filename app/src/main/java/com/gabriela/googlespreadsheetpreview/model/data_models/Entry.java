package com.gabriela.googlespreadsheetpreview.model.data_models;

import com.google.gson.annotations.SerializedName;

public class Entry {
    private ID id;
    @SerializedName("updated")
    private Updated lastEntryUpdate;
    private Title title;
    private Content content;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Updated getLastEntryUpdate() {
        return lastEntryUpdate;
    }

    public void setLastEntryUpdate(Updated lastEntryUpdate) {
        this.lastEntryUpdate = lastEntryUpdate;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
