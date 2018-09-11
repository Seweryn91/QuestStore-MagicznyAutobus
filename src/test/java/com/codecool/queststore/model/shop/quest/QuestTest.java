package com.codecool.queststore.model.shop.quest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {


    @Test
    void testConstructorNullParameters(){
        boolean exceptionThrown = false;
        try{
            Quest quest = new Quest(0,null, null,0,null,null,null,false,0,0);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }


    @Test
    void testConstructorNegativeParameters(){
        boolean exceptionThrown = false;
        try{
            Quest quest = new Quest(-5,"name", "desc",-5,"imgName","imgMkdName",null,false,-5,-5);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

}