package com.isen.test.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.isen.test.model.User;
import com.isen.test.service.ServiceUser;

@ContextConfiguration("classpath:/controller-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DisplayUserTest {

    private MockMvc mockMvc;

    @Inject
    private User user;

    private Object[] mocks;

    List<User> listuser = new ArrayList<User>();

    @Inject
    private DisplayUser userController;

    @Inject
    private ServiceUser userService;

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
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mocks = new Object[] {
            userService
        };
    }

    @After
    public void tearDown() {
        reset();
    }

    @Test
    public void displayuserTest() throws Exception {
        EasyMock.expect(userService.searchUser()).andReturn(listuser);
        replay();
        mockMvc.perform(get("/DisplayUser")).andExpect(status().isOk());
        verify();
    }

    @Test
    public void createTest() throws Exception {
        user = (User) EasyMock.anyObject();
        userService.createUser(user.getName(), user.getSurname(), user.getAge());
        replay();
        mockMvc.perform(post("/create")).andExpect(status().isOk())
                .andExpect(model().attribute("create", hasProperty("name", is(user.getName()))))
                .andExpect(model().attribute("create", hasProperty("surname", is(user.getSurname()))))
                .andExpect(model().attribute("create", hasProperty("age", is(user.getAge()))));
        ;
        verify();
    }

    @Test
    public void updateTest() throws Exception {

    }
}
