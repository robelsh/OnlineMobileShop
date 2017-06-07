package com.isen.test.model;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/model-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MobileTest {

    @Inject
    public Mobile mobile;

    @Test
    public void testGetSetId() {
        int id = 10;
        mobile.setId(id);
        assertEquals(id, mobile.getId());
    }

    @Test
    public void testGetSetBrand() {
        String brand = "brand";
        mobile.setBrand(brand);
        assertEquals(brand, mobile.getBrand());
    }

    @Test
    public void testGetSetModel() {
        String model = "model";
        mobile.setModel(model);
        assertEquals(model, mobile.getModel());
    }

    @Test
    public void testGetSetYear() {
        int year = 1994;
        mobile.setYear(year);
        assertEquals(year, mobile.getYear());
    }
}
