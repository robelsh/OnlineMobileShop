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

import com.isen.test.model.Mobile;
import com.isen.test.repository.RepositoryMobile;

@ContextConfiguration("classpath:/service-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceMobileTest {

    @Inject
    public ServiceMobile serviceMobile;

    @Inject
    public Mobile mobile;

    List<Mobile> listmobile = new ArrayList<Mobile>();

    @Inject
    private RepositoryMobile mobileRepository;

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
            mobileRepository
        };

    }

    @After
    public void tearDown() {
        reset();
    }

    @Test
    public void testgetAllMobiles() {
        mobileRepository.getAllMobiles();
    }
}
