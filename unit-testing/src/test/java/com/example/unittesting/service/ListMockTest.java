package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List <String>mock = mock(List.class);
    @Test
    public void size_basic(){

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());

    }
    @Test
    public void returnDifferentValues(){

        //first time it returns 5 and second time it returns 10
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){
        List mock = mock(List.class);

        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));

    }
    @Test
    public void returnWithGenericParameters(){

        //Any integer will return  in28minutes
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));

    }

    @Test
    public void verificationTests(){

       // verify  if a specific method is verified with a specific value on a mock
        String value1= mock.get(0);
        String value2= mock.get(1);
        verify(mock).get(0);
        verify(mock).get(1);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(7);

    }


//Capturing arguments that are passed to method calls in a mock
    @Test
    public void argumentCapturing(){
        mock.add("Something");


        ArgumentCaptor<String> captor =ArgumentCaptor.forClass(String.class);
        // we are trying to capture the argument which was added to add method

        verify(mock).add(captor.capture());
        assertEquals("Something",captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing(){
        mock.add("Something0");
        mock.add("Something1");


        ArgumentCaptor<String> captor =ArgumentCaptor.forClass(String.class);
        // we are trying to capture the argument which was added to add method

        verify(mock, times(2)).add(captor.capture());

      List<String>allValues = captor.getAllValues();
        assertEquals("Something0",allValues.get(0));
        assertEquals("Something1",allValues.get(1));

    }

    @Test
    public void mocking(){
        ArrayList arrayListMock =mock(ArrayList.class);
      System.out.println(  arrayListMock.get(0)); //null
        System.out.println(   arrayListMock.size()); //0
        arrayListMock.add("test1");
        arrayListMock.add("test2");
        System.out.println(   arrayListMock.size());//0

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }
//spy uses the real class, the original behaviour of the array List is maintained
    @Test
    public void spying(){
        ArrayList arrayListSpy =spy(ArrayList.class);
     //   System.out.println(  arrayListSpy.get(0)); //Exception coz the arrayList doesnot have any elements
        System.out.println(  arrayListSpy.size()); //0
        arrayListSpy.add("test1");
        arrayListSpy.add("test2");
        System.out.println(  arrayListSpy.size());//2

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5
        arrayListSpy.add("test3"); // size will remain 5 coz the size method was overriden
        System.out.println(arrayListSpy.size());//5
    }
}
