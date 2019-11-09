package com.obadajasem.testapp.service;

import com.obadajasem.testapp.modal.post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface placeholder {

    @GET("posts")
    Call<List<post>> geAllPosts();

    @GET("posts/{id}/comments")
    Call<List<post>> geAllPosts(@Path("id") int id);



    @GET("posts")
    Call<List<post>> geAllPostsbyid(@Query("userId") int id);

    @POST("posts")
    Call<post> createPost(@Body post newpost);

    @PUT("posts/{id}")
    Call<post> putPost(@Path("id") int id, @Body post newpost);


}
