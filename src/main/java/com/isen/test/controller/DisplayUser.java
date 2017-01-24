package com.isen.test.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isen.test.model.User;
import com.isen.test.model.UserForm;
import com.isen.test.model.UserUpdate;
import com.isen.test.model.UserUpdateForm;
import com.isen.test.service.ServiceUser;

@Controller
public class DisplayUser {

    @Inject
    private ServiceUser service;

    @RequestMapping(value = "/DisplayUser", method = RequestMethod.GET)
    public String displayuser(ModelMap Model) {

        final List<User> model = service.searchUser();
        List<UserUpdate> usersDto = convertModelToDTO(model);
        if (Model.get("create") == null) {
            Model.addAttribute("create", new UserForm());
        }
        if (Model.get("update") == null) {
            UserUpdateForm update = new UserUpdateForm();
            update.setUsers(usersDto);
            Model.addAttribute("update", update);
        }
        return "listuser";
    }

    private List<UserUpdate> convertModelToDTO(List<User> model) {
        List<UserUpdate> usersDto = new ArrayList<UserUpdate>();
        for (User user : model) {
            UserUpdate dto = new UserUpdate();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setSurname(user.getSurname());
            dto.setAge(user.getAge());
            usersDto.add(dto);
        }
        return usersDto;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("create") final UserForm create, final BindingResult BindingResult,
            final ModelMap Model) {
        if (!BindingResult.hasErrors()) {
            service.createUser(create.getName(), create.getSurname(), create.getAge());
        }
        return displayuser(Model);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("idUser") final int idUser, final ModelMap Model) {
        service.deleteUser(idUser);
        return displayuser(Model);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("update") UserUpdateForm update, BindingResult pBindingResult, ModelMap Model) {
        List<User> listuser = new LinkedList<User>();
        if (!pBindingResult.hasErrors()) {
            for (UserUpdate UpdateUser : update.getUsers()) {
                User user = new User();
                user.setId(UpdateUser.getId());
                Integer age = Integer.valueOf(UpdateUser.getAge());
                user.setAge(age);
                user.setName(UpdateUser.getName());
                user.setSurname(UpdateUser.getSurname());
                listuser.add(user);
            }
            service.updateUser(listuser);
        }
        return displayuser(Model);
    }
}
