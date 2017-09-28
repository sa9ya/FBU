package com.example.sa9ya.fbu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by sa9ya on 06.09.2017.
 */

public class Main extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ApiModel> posts;
    private static ApiNews umoriliApi;

    public static void setUmrapi(ApiNews umoriliApi) {
        Main.umoriliApi = umoriliApi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_scren_layout);


        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsNews adapter = new PostsNews(posts);
        recyclerView.setAdapter(adapter);

        umoriliApi.getData().enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Toast.makeText(Main.this, "Нет интернет соединения!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
