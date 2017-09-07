package com.development.beshoy.taskcardview.network;

import android.content.Context;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bisho on 07-Sep-17.
 */

public class ApiService {


    private static ArticlesEndpoint apiService;
    private static Retrofit retrofit;


    private ApiService() {
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(WSConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
        return retrofit;
    }


    public static ArticlesEndpoint getApiService() {
        if (apiService == null) {
            apiService = getRetrofitInstance().create(ArticlesEndpoint.class);
            return apiService;
        }
        return apiService;

    }

}
