package com.example.unittesting.service;

import com.example.unittesting.repository.BusinessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)

//@RunWith(MockitoJUnitRunner.class)
public class BusinessMockTest {


    @InjectMocks
    BusinessServiceImpl businessServiceImpl;
    @Mock
    BusinessRepository dataServiceMock;

    @BeforeEach
    void beforeEach() {

        MockitoAnnotations.initMocks(this);

    }
/*
    @BeforeEach
    void init() {
        businessServiceImpl = new BusinessServiceImpl();
        dataServiceMock = mock(BusinessRepository.class);
        businessServiceImpl.setBusinessRepository(dataServiceMock);
    }
*/

    @Test
    public void calculateSumUsingDataService_basic() {

        // when someone calls dataServiceMock-- Method--retrieveAl()----return new int[]{1,2,3};
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{1, 2, 3});

        assertEquals(6, businessServiceImpl.calculateSumUsingDataService(), "calculating sum of numbers in the array");

    }

    @Test
    public void calculateSumUsingDataService_empty() {

        // when someone calls dataServiceMock-- Method--retrieveAl()----return new int[]{};
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{});

        assertEquals(0, businessServiceImpl.calculateSumUsingDataService(), "calculating sum of numbers in the array");

    }

    @Test
    public void calculateSumUsingDataService_one() {

        // when someone calls dataServiceMock-- Method--retrieveAl()----return new int[]{3};
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{3});

        assertEquals(3, businessServiceImpl.calculateSumUsingDataService(), "calculating sum of numbers in the array");

    }
}
