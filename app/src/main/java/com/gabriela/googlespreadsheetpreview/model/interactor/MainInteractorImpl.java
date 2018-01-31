package com.gabriela.googlespreadsheetpreview.model.interactor;

import com.gabriela.googlespreadsheetpreview.base.BaseImpl;
import com.gabriela.googlespreadsheetpreview.base.RestUtils;
import com.gabriela.googlespreadsheetpreview.model.data_models.SpreadSheet;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainInteractorImpl extends BaseImpl implements MainInteractor {

    public void checkDisposable(final int pos, String SheetNumber, final Listener listener) {
        addObserver(getObservable(SheetNumber).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<SpreadSheet>() {
            @Override
            public void onNext(SpreadSheet spreadSheet) {
                listener.onSuccess(pos, spreadSheet.getFeed());
            }

            @Override
            public void onError(Throwable e) {
                listener.onError();
            }

            @Override
            public void onComplete() {

            }
        }));
    }

    @Override
    public Observable<SpreadSheet> getObservable(String sheetNumber) {
        return RestUtils.getAPI().spreadSheet(sheetNumber);
    }
}
