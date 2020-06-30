package com.example.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actual="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quatity\":100}";

    @Test
    public void jsonAssert_StrictTrueExactMatchExceptSpaces() throws JSONException {
        String expected="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quatity\":100}";
        JSONAssert.assertEquals(expected, actual, true);
    }
    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        //removed quatity
        String expected="{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void jsonAssert_withoutEscapeCharacters() throws JSONException {
        //removed quatity
        String expected="{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expected, actual, false);
    }
}
