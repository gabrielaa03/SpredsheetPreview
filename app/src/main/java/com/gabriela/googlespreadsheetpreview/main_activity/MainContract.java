package com.gabriela.googlespreadsheetpreview.main_activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainContract {

    interface MainView {
        void sendData(int pos, String title, Map<String, String> cellsAndData);
    }

    interface MainPresenter {

        void onStart();

        void onStop();

        void setData(int position, int sheetNumber);
    }

    interface BetweenFragmentAndActivityInterface {

        void sendDataToActivity(int position, int sheetNumber);
    }
}
