package com.gabriela.googlespreadsheetpreview.model.data_models;

import com.google.gson.annotations.SerializedName;

public class Title {
    private String type;
    @SerializedName("$t")
    private String text;

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }
}
