package com.travelapp.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecentsDataTest {
    @Test
    public void getImageUrl() {
        Integer input = 20;
        Integer output;
        Integer expected = 20;
        RecentsData recentsData = new RecentsData("","","",input);
        output = recentsData.getImageUrl();
        assertEquals(expected,output);
    }
    @Test
    public void getPlaceName() {


        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        RecentsData recentsData = new RecentsData(input,"","",null);
        output = recentsData.getPlaceName();
        assertEquals(expected,output);

    }

    @Test
    public void getCountryName() {


        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        RecentsData recentsData = new RecentsData("",input,"",null);
        output = recentsData.getCountryName();
        assertEquals(expected,output);

    }

    @Test
    public void getPrice() {

        String input = "kisuakta";
        String output;
        String expected = "kisuakta";
        RecentsData recentsData = new RecentsData("","",input,null);
        output = recentsData.getPrice();
        assertEquals(expected,output);

    }
}