package com.example.sa9ya.fbu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sa9ya on 26.09.2017.
 */

public class Controller {

    static final String BASE_URL = "http://fbu.ua/";

    public static ApiNews getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiNews news = retrofit.create(ApiNews.class);
        return news;
    }
}