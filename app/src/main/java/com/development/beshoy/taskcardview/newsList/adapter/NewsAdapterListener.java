package com.development.beshoy.taskcardview.newsList.adapter;

import com.development.beshoy.taskcardview.newsList.modules.Article;

/**
 * Created by bisho on 07-Sep-17.
 */

public interface NewsAdapterListener {

    void addToCalendar(Article article);
    void readMore(Article article);

}
