package com.example.billy.jumpit.controller.activities.managers;

import com.example.billy.jumpit.model.User;

import java.util.List;

public interface UserCallback {
    void onSuccess(List<User> userList);
    void onSucces();
    void onSucces(User user);
    void onFailure(Throwable t);
}
