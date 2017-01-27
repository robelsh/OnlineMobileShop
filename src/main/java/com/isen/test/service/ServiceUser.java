package com.isen.test.service;

import java.util.List;

import com.isen.test.model.User;

public interface ServiceUser {
    List<User> getAllUsers();

    User searchUserById(final int idUser);
    
    User searchUserByName(final String nameUser);
    
    void createUser(final String name, final String surname, final int age);

    void deleteUser(final int idUser);

    void updateUsers(final List<User> user);
    
    void updateUser(User user);

}
