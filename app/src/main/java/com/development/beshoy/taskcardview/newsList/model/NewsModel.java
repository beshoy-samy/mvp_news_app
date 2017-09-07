package com.development.beshoy.taskcardview.newsList.model;

import com.development.beshoy.taskcardview.newsList.modules.Article;

import java.util.ArrayList;

/**
 * Created by bisho on 07-Sep-17.
 */

public interface NewsModel {

    void startFetchingArticles(ResponseCallbacks responseCallbacks);

    interface ResponseCallbacks {
        void onResponseSuccess(ArrayList<Article> articles);

        void onResponseFailure(Exception e);
    }
}
