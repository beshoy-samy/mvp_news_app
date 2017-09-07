package com.development.beshoy.taskcardview.newsList.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.development.beshoy.taskcardview.BaseActivity;
import com.development.beshoy.taskcardview.R;
import com.development.beshoy.taskcardview.newsList.adapter.NewsAdapter;
import com.development.beshoy.taskcardview.newsList.adapter.NewsAdapterListener;
import com.development.beshoy.taskcardview.newsList.modules.Article;
import com.development.beshoy.taskcardview.newsList.presenter.NewsPresenter;
import com.development.beshoy.taskcardview.newsList.presenter.NewsPresenterImp;

import java.util.ArrayList;

import butterknife.BindView;

public class NewsActivity extends BaseActivity implements NewsView,
        SwipeRefreshLayout.OnRefreshListener, NewsAdapterListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.news_recycler_view)
    RecyclerView newsRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.no_internet_error)
    TextView internetError;

    private NewsPresenter presenter;
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_news;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        presenter = new NewsPresenterImp(this, this);
        toolbar.setTitle(getString(R.string.new_scientist));
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, R.color.colorPrimaryDark));
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        newsAdapter = new NewsAdapter(this, this);
        newsRecyclerView.setAdapter(newsAdapter);
        presenter.onRefresh();
    }

    @Override
    public void onRefresh() {
        presenter.onRefresh();
    }

    @Override
    public void showInternetErrorMessage() {
        internetError.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopRefreshLayout() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void startRefreshing() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void updateArticlesToAdapter(ArrayList<Article> articles) {
        newsAdapter.setArticles(articles);
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void addToCalendar(Article article) {
        presenter.addToCalendar(article);
    }

    @Override
    public void readMore(Article article) {

    }
}
