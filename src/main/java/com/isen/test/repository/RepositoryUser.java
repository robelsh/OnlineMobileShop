package com.isen.test.repository;

import java.util.List;

import com.isen.test.model.User;

public interface RepositoryUser {
    List<User> getAllUsers();

    void createUser(final User userRepository);

    void deleteUser(final User userRepository);

    void updateUser(final User userRepository);

    User searchUserById(final User userRepository);
    
    User searchUserByName(final User userRepository);

}
