package com.ncr.test.model;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/model-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Inject
    public User user;

    @Test
    public void testGetSetId() {
        int id = 10;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void testGetSetName() {
        String name = "name";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetSetSurname() {
        String surname = "surname";
        user.setSurname(surname);
        assertEquals(surname, user.getSurname());
    }

    @Test
    public void testGetSetAge() {
        int age = 10;
        user.setAge(age);
        assertEquals(age, user.getAge());
    }
}
