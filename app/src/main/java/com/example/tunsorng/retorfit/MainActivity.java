package com.example.tunsorng.retorfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tunsorng.retorfit.data.ServiceGenerator;
import com.example.tunsorng.retorfit.data.service.ArticleService;
import com.example.tunsorng.retorfit.model.response.ArticleResonse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArticleService service;
    private static final String TAG= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service=ServiceGenerator.createServices(ArticleService.class);
        Call<ArticleResonse> call =service.getArticle(1,20);
        call.enqueue(new Callback<ArticleResonse>() {
            @Override
            public void onResponse(Call<ArticleResonse> call, Response<ArticleResonse> response) {
                Log.e(TAG,"onRespones:"+response.body().toString());
            }

            @Override
            public void onFailure(Call<ArticleResonse> call, Throwable t) {
                Log.e(TAG,"onFailure:"+t.toString());

            }
        });
    }
}
