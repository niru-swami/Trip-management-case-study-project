package com.example.TripManagementApplication.service;

import com.example.TripManagementApplication.model.User;

public interface UserService {
    void addUser(User user);

    String login(String username, String password);

    boolean isLoggedIn(String token);

    void logOut(String token);
}
