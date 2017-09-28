package com.example.sa9ya.fbu;

/**
 * Created by sa9ya on 26.09.2017.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiNews {

    @GET("/api/default")
    Call<List<ApiModel>> getData();
}