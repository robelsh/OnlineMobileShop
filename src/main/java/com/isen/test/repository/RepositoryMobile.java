package com.isen.test.repository;

import java.util.List;

import com.isen.test.model.Mobile;

public interface RepositoryMobile {
	
    List<Mobile> getAllMobiles();
    
    void createUser(final Mobile mobileRepository);

    void deleteMobile(final Mobile mobileRepository);
}
