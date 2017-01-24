package com.isen.test.service;

import java.util.List;

import com.isen.test.model.User;

public interface ServiceUser {
    List<User> searchUser();

    User searchOneUser(final int idUser);

    void createUser(final String name, final String surname, final int age);

    void deleteUser(final int idUser);

    void updateUser(final List<User> user);
}
