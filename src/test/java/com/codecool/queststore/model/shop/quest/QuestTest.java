package com.codecool.queststore.model.shop.quest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {

    private Quest quest = new Quest(1,"d","u",3,"p","a",null,false,3,1);

    @Test
        void testSomething(){
            System.out.println("CHUJ");
            boolean isDone = this.quest.IS_DONE();
            assertFalse(isDone);
        }

}