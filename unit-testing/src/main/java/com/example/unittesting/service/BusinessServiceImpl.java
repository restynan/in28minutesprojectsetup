package com.example.unittesting.service;

import com.example.unittesting.repository.BusinessRepository;

public class BusinessServiceImpl {



    BusinessRepository businessRepository;

    public void setBusinessRepository(BusinessRepository businessRepository){
        this.businessRepository=businessRepository;

    }

    public int calculateSumUsingDataService( ){
        int sum=0;
        int []data= businessRepository.retrieveAll();
        for(int value:data)
        {
            sum+=value;
        }
        return sum;

    }



















    public int calculateSum(int []data ){
        int sum=0;
        for(int value:data)
        {
            sum+=value;
        }
        return sum;

    }
}
