package com.isen.test.repository;

import java.util.List;

import com.isen.test.model.Mobile;

public interface RepositoryMobile {
	
    List<Mobile> getAllMobiles();
    
    String updateMobile(Mobile mobile);
    
    Mobile getMobileById(final int id);
}
