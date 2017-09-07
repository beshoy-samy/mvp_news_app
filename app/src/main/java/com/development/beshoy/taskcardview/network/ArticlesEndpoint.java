package com.development.beshoy.taskcardview.network;


import com.development.beshoy.taskcardview.newsList.modules.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bisho on 07-Sep-17.
 */

public interface ArticlesEndpoint {

    @GET(WSConstants.GET_ARTICLES)
    Call<NewsResponse> getArticles(@Query(WSConstants.SOURCE_QUERY) String source,
                                   @Query(WSConstants.SORT_BY_QUERY) String sortBy,
                                   @Query(WSConstants.API_KEY_QUERY) String apiKey);


}
