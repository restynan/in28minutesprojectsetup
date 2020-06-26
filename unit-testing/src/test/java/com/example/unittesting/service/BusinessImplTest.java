package com.example.unittesting.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplTest {


    @Test
    public void calculateSumTest(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
        int []arr={1,2,3};

        assertEquals(6, businessServiceImpl.calculateSum(arr),"calculating sum of numbers in the array");

    }

    @Test
    public void calculateSum_empty(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
        int []arr={};

        assertEquals(0, businessServiceImpl.calculateSum(arr),"calculating sum of numbers in the array");

    }

    @Test
    public void calculateSum_one(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
        int []arr={3};

        assertEquals(3, businessServiceImpl.calculateSum(arr),"calculating sum of numbers in the array");

    }
}