package com.development.beshoy.taskcardview.newsList.presenter;

import com.development.beshoy.taskcardview.newsList.modules.Article;

/**
 * Created by bisho on 07-Sep-17.
 */

public interface NewsPresenter {
    void onRefresh();

    void addToCalendar(Article article);
}
