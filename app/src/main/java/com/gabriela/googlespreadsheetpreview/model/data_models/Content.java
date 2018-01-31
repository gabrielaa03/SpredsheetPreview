package com.gabriela.googlespreadsheetpreview.model.data_models;

import com.google.gson.annotations.SerializedName;

public class Content {
    private String type;
    @SerializedName("$t")
    private String contentText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
