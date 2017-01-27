package com.isen.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.isen.test.model.Mobile;
import com.isen.test.model.MobileDTO;
import com.isen.test.service.ServiceMobile;

@Controller
public class MobileController {
    @Inject
    private ServiceMobile service;
    
    private List<MobileDTO> convertModelToDTO(List<Mobile> model) {
        List<MobileDTO> mobilesDto = new ArrayList<MobileDTO>();
        for (Mobile mobile : model) {
            MobileDTO dto = new MobileDTO();
            dto.setId(mobile.getId());
            dto.setBrand(mobile.getBrand());
            dto.setDescription(mobile.getDescription());
            dto.setModel(mobile.getModel());
            dto.setPrice(mobile.getPrice());
            dto.setYear(mobile.getYear());
            mobilesDto.add(dto);
        }
        return mobilesDto;
    }
    
    private MobileDTO convertModelToDTO(Mobile model) {
    	MobileDTO mobileDto = new MobileDTO();
    	mobileDto.setId(model.getId());
    	mobileDto.setBrand(model.getBrand());
    	mobileDto.setDescription(model.getDescription());
    	mobileDto.setModel(model.getModel());
    	mobileDto.setPrice(model.getPrice());
    	mobileDto.setYear(model.getYear());
        return mobileDto;
    }
    
    @RequestMapping(value = "/DisplayMobile", method = RequestMethod.GET)
    public String displayuser(ModelMap Model) {
        final List<Mobile> model = service.getAllMobiles();
        List<MobileDTO> mobilesDto = convertModelToDTO(model);
        String json = new Gson().toJson(mobilesDto);
        Model.addAttribute("json", json);
        return "listuser";
    }
    
    @RequestMapping(value = "/deleteMobile", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("idMobile") final int idMobile, final ModelMap Model) {
        service.deleteMobile(idMobile);
        return "listuserTest";
    }
 }
