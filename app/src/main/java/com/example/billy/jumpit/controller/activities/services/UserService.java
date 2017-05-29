package com.example.billy.jumpit.controller.activities.services;

import com.example.billy.jumpit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    @GET("/api/users")
    Call<List<User>> getAllUsers(
            @Header("Authorization") String Authorization
    );

    @POST("api/users") // Se tiene que cambiar en un interfaz propia
    Call<User> createUser(
            @Header("Authorization") String Authorization,
            @Body User user);


    @PUT("api/users")
    Call<User> updateUser(
            @Header("Authorization") String Authorization,
            @Body User user);

    @DELETE("api/users/{id}")
    Call<Void> deleteUser(
            @Header("Authorization") String Authorization,
            @Path("id") Long id);


}
