package com.gabriela.googlespreadsheetpreview.model.interactor;

import com.gabriela.googlespreadsheetpreview.base.Base;
import com.gabriela.googlespreadsheetpreview.model.data_models.SpreadSheet;

import io.reactivex.Observable;

public interface MainInteractor extends Base {
    void checkDisposable(int position, String sheetNumber, Listener listener);
    Observable<SpreadSheet> getObservable(String sheetNumber);
}
