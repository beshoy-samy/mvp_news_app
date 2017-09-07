package com.development.beshoy.taskcardview.newsList.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.development.beshoy.taskcardview.R;
import com.development.beshoy.taskcardview.newsList.modules.Article;
import com.development.beshoy.taskcardview.utils.ImageLoadingUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bisho on 07-Sep-17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private ArrayList<Article> articles;
    private Activity activity;
    private NewsAdapterListener listener;

    public NewsAdapter(Activity activity, NewsAdapterListener listener) {
        this.activity = activity;
        this.listener = listener;
        articles = new ArrayList<>();
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.article_item, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = articles.get(position);
        ImageLoadingUtils.loadImageURL(activity, article.getUrlToImage(), holder.articleCoverImage);
        holder.articleTitle.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.article_image)
        ImageView articleCoverImage;
        @BindView(R.id.article_title)
        TextView articleTitle;
        @BindView(R.id.add_to_calendar)
        Button addToCalendar;
        @BindView(R.id.read_more)
        Button readMore;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.add_to_calendar)
        void addToCalendar(){
            listener.addToCalendar(articles.get(getAdapterPosition()));
        }

        @OnClick(R.id.read_more)
        void readMore(){
            listener.readMore(articles.get(getAdapterPosition()));
        }

    }

}
