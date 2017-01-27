package com.isen.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isen.test.model.Mobile;
import com.isen.test.repository.RepositoryMobile;

@Service
public class ServiceMobileImpl implements ServiceMobile {

    @Inject
    private RepositoryMobile repoMobile;

    @Transactional(readOnly = true)
	public List<Mobile> getAllMobiles() {
        List<Mobile> mobiles = repoMobile.getAllMobiles();
        return mobiles;
	}
    
    @Transactional
	public void deleteMobile(int idMobile) {
    	final Mobile mobile = new Mobile();
        mobile.setId(idMobile);
        repoMobile.deleteMobile(mobile);
	}
}