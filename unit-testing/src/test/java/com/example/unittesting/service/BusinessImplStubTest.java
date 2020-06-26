package com.example.unittesting.service;

import com.example.unittesting.repository.BusinessRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BusinessRepositoryStub implements BusinessRepository{

    @Override
    public int[] retrieveAll() {
        return new int[]{1,2,3};
    }
}

class BusinessImplStubTest {


    @Test
    public void calculateSumUsingDataService_basic(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
          businessServiceImpl.setBusinessRepository(new BusinessRepositoryStub());

        assertEquals(6, businessServiceImpl.calculateSumUsingDataService(),"calculating sum of numbers in the array");

    }

    @Test
    public void calculateSumUsingDataService_empty(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
        int []arr={};

        assertEquals(0, businessServiceImpl.calculateSumUsingDataService(),"calculating sum of numbers in the array");

    }

    @Test
    public void calculateSumUsingDataService_one(){
        BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
        int []arr={3};

        assertEquals(3, businessServiceImpl.calculateSumUsingDataService(),"calculating sum of numbers in the array");

    }
}