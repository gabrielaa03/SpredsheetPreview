package com.gabriela.googlespreadsheetpreview.base;

import com.gabriela.googlespreadsheetpreview.model.data_models.SpreadSheet;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestInterface {
    @GET ("{worksheet_id}/public/basic?alt=json")
    Observable<SpreadSheet> spreadSheet (@Path("worksheet_id") String sheetID);
}
