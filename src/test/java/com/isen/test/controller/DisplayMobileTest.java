package com.isen.test.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.isen.test.model.Mobile;
import com.isen.test.service.ServiceMobile;

@ContextConfiguration("classpath:/controller-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DisplayMobileTest {

    private MockMvc mockMvc;

    @Inject
    private Mobile mobile;

    private Object[] mocks;

    List<Mobile> listmobile = new ArrayList<Mobile>();

    @Inject
    private MobileController mobileController;

    @Inject
    private ServiceMobile mobileService;

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
        mockMvc = MockMvcBuilders.standaloneSetup(mobileController).build();
        mocks = new Object[] {
            mobileService
        };
    }

    @After
    public void tearDown() {
        reset();
    }

    @Test
    public void displaymobileTest() throws Exception {
        EasyMock.expect(mobileService.getAllMobiles()).andReturn(listmobile);
        replay();
        mockMvc.perform(get("/DisplayMobile")).andExpect(status().isOk());
        verify();
    }

    @Test
    public void createTest() throws Exception {
        mobile = (Mobile) EasyMock.anyObject();
        //Todo create test
    }

    @Test
    public void updateTest() throws Exception {

    }
}
