package com.isen.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isen.test.model.User;
import com.isen.test.repository.RepositoryUser;

@Service
public class ServiceUserImpl implements ServiceUser {

    @Inject
    private RepositoryUser repoUser;

    @Transactional(readOnly = true)
    public List<User> searchUser() {

        List<User> searchUser = repoUser.searchUser();
        return searchUser;
    }

    @Transactional
    public void createUser(String name, String surname, int age) {

        final User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setSurname(surname);

        repoUser.createUser(user);
    }

    @Transactional
    public void deleteUser(int idUser) {
        final User user = new User();
        user.setId(idUser);
        repoUser.deleteUser(user);
    }

    @Transactional
    public void updateUsers(List<User> listuser) {
        for (final User user : listuser) {
            repoUser.updateUser(user);
        }
    }

    public User searchUserById(int idUser) {
        final User user = new User();
        user.setId(idUser);
        User searchOneUser = repoUser.searchUserById(user);
        return searchOneUser;
    }

	public void updateUser(User user) {
        repoUser.updateUser(user);
	}

	public User searchUserByName(String nameUser) {
		final User user = new User();
		user.setName(nameUser);
		User searchOneUser = repoUser.searchUserByName(user);
        return searchOneUser;
	}
}