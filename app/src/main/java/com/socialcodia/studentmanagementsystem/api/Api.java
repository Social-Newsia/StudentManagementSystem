package com.socialcodia.studentmanagementsystem.api;

import com.socialcodia.studentmanagementsystem.model.DefaultResponse;
import com.socialcodia.studentmanagementsystem.model.LoginResponse;
import com.socialcodia.studentmanagementsystem.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("users")
    Call<UsersResponse> getUsers();
}
