package com.gabriela.googlespreadsheetpreview.model.interactor;

import com.gabriela.googlespreadsheetpreview.model.data_models.Feed;

public interface Listener {
    void onSuccess(int pos, Feed feed);

    void onError();
}
