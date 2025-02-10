package com.example.baitap.test;

import com.example.baitap.Service.XeOTOService;
import com.example.baitap.entity.XeOTO;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XeOTOTest {
    XeOTOService service;

    @BeforeEach
    public void setup() {
        service = new XeOTOService();
    }

    @Test
    public void testAddValid() {
        XeOTO xe = new XeOTO(1, "MayBack", 1000f, "Khong");
        service.addXeOTO(xe);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test
    public void updateValid() {
        XeOTO xe = new XeOTO(1, "MayBack" , 1000f , "Khong");
        service.addXeOTO(xe);
        XeOTO xe1 = new XeOTO(1, "MayBack" , 1000000f , "Khong");
        service.updateXeOTO(xe1, 1);
        Assert.assertEquals(1000000f, service.getAll().get(0).getGia());
    }

    @Test
    public void deleteValid() {
        XeOTO xe = new XeOTO(1, "MayBack" , 1000f , "Khong");
        service.addXeOTO(xe);
        int sizeBefore = service.getAll().size();
        service.deleteXeOTO(1);
        int sizeAfter = service.getAll().size();
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void deleteInValid() {
        XeOTO xe = new XeOTO(1, "MayBack" , 1000f , "Khong");
        service.addXeOTO(xe);
        int sizeBefore = service.getAll().size();
        service.deleteXeOTO(1);
        int sizeAfter = service.getAll().size();
        Assert.assertEquals(sizeBefore , sizeAfter);
    }

    @Test
    public void testSearchXeOtoValid() {
        XeOTO xe = new XeOTO(1, "MayBack" , 1000f , "Khong");
        service.addXeOTO(xe);

        XeOTO foundXeOTO = service.searchXeOTO(1);

        Assert.assertEquals(1, foundXeOTO.getId());
    }

    @Test
    public void testSearchXeOtoInValid() {
        XeOTO xe = new XeOTO(1, "MayBack" , 1000f , "Khong");
        service.addXeOTO(xe);

        XeOTO foundXeOTO = service.searchXeOTO(1);

        Assert.assertEquals(2, foundXeOTO.getId());
    }

}
