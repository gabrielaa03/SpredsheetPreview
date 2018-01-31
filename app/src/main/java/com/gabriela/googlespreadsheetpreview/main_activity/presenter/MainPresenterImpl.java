package com.gabriela.googlespreadsheetpreview.main_activity.presenter;

import android.util.Log;

import com.gabriela.googlespreadsheetpreview.base.BaseImpl;
import com.gabriela.googlespreadsheetpreview.main_activity.MainContract;
import com.gabriela.googlespreadsheetpreview.model.data_models.Entry;
import com.gabriela.googlespreadsheetpreview.model.data_models.Feed;
import com.gabriela.googlespreadsheetpreview.model.data_models.SpreadSheet;
import com.gabriela.googlespreadsheetpreview.model.data_models.Title;
import com.gabriela.googlespreadsheetpreview.model.interactor.Listener;
import com.gabriela.googlespreadsheetpreview.model.interactor.MainInteractor;
import com.gabriela.googlespreadsheetpreview.model.interactor.MainInteractorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPresenterImpl implements MainContract.MainPresenter, Listener {
    private MainContract.MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainContract.MainView view) {
        this.view = view;
        interactor = new MainInteractorImpl();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        interactor.disposeCompositeD();
    }


    @Override
    public void setData(int position, int sheetNumber) {
        interactor.checkDisposable(position, String.valueOf(sheetNumber), this);
    }

    @Override
    public void onSuccess(int position, Feed feed) {
        String title = feed.getTitle().getText();
        List<Entry> listOfEntries = new ArrayList<>();
        listOfEntries.addAll(feed.getEntry());

        Map<String, String> cellsAndData = new HashMap<>();
        for (int i = 0; i < listOfEntries.size(); i++) {
            cellsAndData.put(listOfEntries.get(i).getTitle().getText(), listOfEntries.get(i).getContent().getContentText());
        }

        view.sendData(position, title, cellsAndData);
    }

    @Override
    public void onError() {
        Log.d("error", "Cannot get response.");
    }
}
