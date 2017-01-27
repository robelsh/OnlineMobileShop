package com.isen.test.service;

import java.util.List;

import com.isen.test.model.Mobile;

public interface ServiceMobile {
    List<Mobile> getAllMobiles();
    
    void deleteMobile(final int idMobile);

}
