package com.example.billy.jumpit.controller.activities.managers;

import android.util.Log;

import com.example.billy.jumpit.controller.activities.services.UserService;
import com.example.billy.jumpit.model.User;
import com.example.billy.jumpit.util.CustomProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserManager {
    private static UserManager ourInstance;
    private List<User> users;
    private Retrofit retrofit;
    private UserService userService;

    private UserManager() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        retrofit = new Retrofit.Builder()
                .baseUrl(CustomProperties.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .build();

        userService = retrofit.create(UserService.class);
    }

    public static UserManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new UserManager();
        }

        return ourInstance;
    }


    public synchronized void getAllAthletes(final UserCallback userCallback) {
        Call<List<User>> call = userService.getAllUsers(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    userCallback.onSuccess(users);
                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("AthleteManager->", "getAllAthletes()->ERROR: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    public User getUser(String id) {
        for (User user : users) {
            if (id.equals(user.getId())) {
                return user;
            }
        }

        return null;
    }

    /* POST - CREATE PLAYER */

    public synchronized void createAthlete(final UserCallback userCallback, User user) {
        Call<User> call = userService.createUser(UserLoginManager.getInstance().getBearerToken(), user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    //playerCallback.onSuccess1(apuestas1x2);
                    Log.e("Atleta->", "createAthlete: OK" + 100);

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserManager->", "createUser: " + t);
                userCallback.onFailure(t);
            }
        });
    }

    /* PUT - UPDATE Athlete */
    public synchronized void updateAthlete(final UserCallback userCallback, User user) {
        Call <User> call = userService.updateUser(UserLoginManager.getInstance().getBearerToken() ,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("Atleta->", "updateAthlete: OOK" + 100);

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("UserManager->", "updateUser: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    /* DELETE - DELETE PLAYER */
    public synchronized void deleteUser(final UserCallback userCallback, Long id) {
        Call <Void> call = userService.deleteUser(UserLoginManager.getInstance().getBearerToken() ,id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("User->", "Deleted: OK");

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("UserManager->", "deleteUser: " + t);

                userCallback.onFailure(t);
            }
        });
    }

}
