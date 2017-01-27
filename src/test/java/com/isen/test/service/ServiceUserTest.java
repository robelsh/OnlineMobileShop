package com.isen.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.isen.test.model.User;
import com.isen.test.repository.RepositoryUser;

@ContextConfiguration("classpath:/service-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceUserTest {

    @Inject
    public ServiceUser serviceUser;

    @Inject
    public User user;

    List<User> listuser = new ArrayList<User>();

    @Inject
    private RepositoryUser userRepository;

    private Object[] mocks = null;

    private void reset() {
        EasyMock.reset(mocks);
    }

    private void verify() {
        EasyMock.verify(mocks);
    }

    private void replay() {
        EasyMock.replay(mocks);
    }

    @Before
    public void initTest() {
        mocks = new Object[] {
            userRepository
        };

    }

    @After
    public void tearDown() {
        reset();
    }

    @Test
    public void testCreateUser() {
        userRepository.createUser((User) EasyMock.anyObject());
        replay();
        serviceUser.createUser(user.getName(), user.getSurname(), user.getAge());
        verify();
    }

    @Test
    public void testUpdateUser() {
        userRepository.updateUser((User) EasyMock.anyObject());
        listuser.add(user);
        replay();
        serviceUser.updateUsers(listuser);
        verify();
    }

    @Test
    public void testDeleteUser() {
        userRepository.deleteUser((User) EasyMock.anyObject());
        replay();
        serviceUser.deleteUser(user.getId());
        verify();
    }

    @Test
    public void testSearchUser() {
        EasyMock.expect(userRepository.getAllUsers()).andReturn(listuser);
        replay();
        listuser = serviceUser.getAllUsers();
        verify();

    }
}
