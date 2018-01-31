package com.gabriela.googlespreadsheetpreview.base;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestUtils {
    public static String URL = "https://spreadsheets.google.com/feeds/cells/1-8cgH92O7gOK16vVIzMQAfDuinCEVfwY4wOwjV4KHlE/";
    public static RestInterface API;

    public static RestInterface getAPI(){
        if (API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URL).build();

            API = retrofit.create(RestInterface.class);
        }
        return API;
    }
}
