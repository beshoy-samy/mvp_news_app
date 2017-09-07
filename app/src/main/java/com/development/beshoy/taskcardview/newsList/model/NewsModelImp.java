package com.development.beshoy.taskcardview.newsList.model;

import com.development.beshoy.taskcardview.network.ApiService;
import com.development.beshoy.taskcardview.network.WSConstants;
import com.development.beshoy.taskcardview.newsList.modules.Article;
import com.development.beshoy.taskcardview.newsList.modules.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bisho on 07-Sep-17.
 */

public class NewsModelImp implements NewsModel {



    @Override
    public void startFetchingArticles(ResponseCallbacks responseCallbacks) {
        ApiService.getApiService().getArticles(WSConstants.SOURCE,
                WSConstants.SORT_BY,
                WSConstants.API_KEY).enqueue(new NewsCallback(responseCallbacks));
    }

    private class NewsCallback implements Callback<NewsResponse> {

        private ResponseCallbacks callbacks;

        public NewsCallback(ResponseCallbacks callbacks) {
            this.callbacks = callbacks;
        }

        @Override
        public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
            callbacks.onResponseSuccess((ArrayList<Article>) response.body().getArticles());
        }

        @Override
        public void onFailure(Call<NewsResponse> call, Throwable t) {
            callbacks.onResponseFailure((Exception) t);
        }
    }
}
