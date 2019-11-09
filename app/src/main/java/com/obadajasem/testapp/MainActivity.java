package com.obadajasem.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.obadajasem.testapp.modal.post;
import com.obadajasem.testapp.service.placeholder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textview;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        placeholder service = retrofit.create(placeholder.class);
        post newpost = new post("Test tit;e");
        // Call<List<post>> postlist = service.geAllPostsbyid(2);
        Call<post> postlist = service.putPost(2,newpost);
        postlist.enqueue(new Callback<post>() {
            @Override
            public void onResponse(Call<post> call, Response<post> response) {
                Log.d(TAG, "onResponse: "+response.body());
                    String s = "";
                    s+="id : "+response.body().getId()+ "\n";
                    s+="UserId : "+response.body().getUserId()+ "\n";
                    s+="body : "+response.body().getBody()+"\n";
                    s+="titile : "+response.body().getTitle()+"\n";
                    s+= "-------------------------"+"\n";
                    textview.append(s);
            }

            @Override
            public void onFailure(Call<post> call, Throwable t) {

            }
        });
//        postlist.enqueue(new Callback<List<post>>() {
//            @Override
//            public void onResponse(Call<List<post>> call, Response<List<post>> response) {
//                if(!response.isSuccessful())
//                    return;
//
//
//                for(post p : response.body()){
//                    Log.d(TAG, "onResponse: "+response.body());
//                    String s = "";
//                    s+="id : "+p.getId()+ "\n";
//                    s+="UserId : "+p.getUserId()+ "\n";
//                    s+="body : "+p.getBody()+"\n";
//                    s+= "-------------------------"+"\n";
//                    textview.append(s);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<post>> call, Throwable t) {
//
//            }
//        });
//


    }
}
