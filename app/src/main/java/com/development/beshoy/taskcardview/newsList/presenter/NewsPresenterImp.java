package com.development.beshoy.taskcardview.newsList.presenter;

import android.app.Activity;
import android.content.Intent;

import com.development.beshoy.taskcardview.newsList.model.NewsModel;
import com.development.beshoy.taskcardview.newsList.model.NewsModelImp;
import com.development.beshoy.taskcardview.newsList.modules.Article;
import com.development.beshoy.taskcardview.newsList.view.NewsView;
import com.development.beshoy.taskcardview.utils.AppUtils;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by bisho on 07-Sep-17.
 */

public class NewsPresenterImp implements NewsPresenter, NewsModel.ResponseCallbacks {

    private NewsView view;
    private NewsModel model;
    private Activity activity;

    public NewsPresenterImp(NewsView view, Activity activity) {
        this.view = view;
        this.activity = activity;
        model = new NewsModelImp();
    }

    @Override
    public void onRefresh() {
        if(AppUtils.checkIfHasNetwork(activity)){
            view.startRefreshing();
            model.startFetchingArticles(this);
        }
        else
            view.showInternetErrorMessage();
    }

    @Override
    public void addToCalendar(Article article) {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", cal.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("title", article.getTitle()+", URL: "+article.getUrl());
        activity.startActivity(intent);
    }

    @Override
    public void onResponseSuccess(ArrayList<Article> articles) {
        view.stopRefreshLayout();
        view.updateArticlesToAdapter(articles);
    }

    @Override
    public void onResponseFailure(Exception e) {
        AppUtils.makeLog(e.getMessage());
        view.stopRefreshLayout();
    }
}
