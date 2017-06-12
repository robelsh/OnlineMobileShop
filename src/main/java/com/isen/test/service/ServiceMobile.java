package com.isen.test.service;

import java.util.List;

import com.isen.test.model.Mobile;

public interface ServiceMobile {
    List<Mobile> getAllMobiles();
 
    String updateMobile(Mobile mobile);
    
    Mobile getMobileById(final int id);    
}
