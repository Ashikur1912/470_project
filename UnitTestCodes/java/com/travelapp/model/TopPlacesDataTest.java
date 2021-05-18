package com.travelapp.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopPlacesDataTest {
    @Test
    public void getImageUrl() {

        Integer input = 20;
        Integer output;
        Integer expected = 20;
        TopPlacesData topPlacesData = new TopPlacesData("","","",input);
        output = topPlacesData.getImageUrl();
        assertEquals(expected,output);
    }
    @Test
    public void getPlaceName() {


        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        TopPlacesData topPlacesData = new TopPlacesData(input,"","",null);
        output = topPlacesData.getPlaceName();
        assertEquals(expected,output);

    }

    @Test
    public void getCountryName() {


        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        TopPlacesData topPlacesData = new TopPlacesData("",input,"",null);
        output = topPlacesData.getCountryName();
        assertEquals(expected,output);

    }

    @Test
    public void getPrice() {

        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        TopPlacesData topPlacesData = new TopPlacesData("","",input,null);
        output = topPlacesData.getPrice();
        assertEquals(expected,output);

    }
}