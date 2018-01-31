package com.gabriela.googlespreadsheetpreview.model.data_models;

import com.google.gson.annotations.SerializedName;

public class ID {
    @SerializedName("$t")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
