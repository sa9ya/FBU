package com.example.sa9ya.fbu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sa9ya on 06.09.2017.
 */

public class loadScren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Main.setUmrapi(Controller.getApi());

        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        finish();
    }
}
