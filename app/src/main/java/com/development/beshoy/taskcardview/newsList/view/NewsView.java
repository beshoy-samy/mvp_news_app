package com.development.beshoy.taskcardview.newsList.view;

import com.development.beshoy.taskcardview.newsList.modules.Article;

import java.util.ArrayList;

/**
 * Created by bisho on 07-Sep-17.
 */

public interface NewsView {


    void showInternetErrorMessage();
    void stopRefreshLayout();
    void startRefreshing();

    void updateArticlesToAdapter(ArrayList<Article> articles);
}
