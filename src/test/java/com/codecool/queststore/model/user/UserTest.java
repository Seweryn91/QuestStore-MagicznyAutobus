package com.codecool.queststore.model.user;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testIsNameIsNotNull() {
        User user = new User("Adam", "Kowalski", "test@wp.pl", "Katowice", 1, Role.MENTOR);
        assertNotNull(user.getNAME());
    }

    @Test
    public void testWrongEmailIllegalArgumentsThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new User("Ola", "Kowalski", "www", "Katowice", 1, Role.MENTOR);
        });
    }

    @Test
    public void testWrongIDIllegalArgumentsThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new User("Ola", "Kowalski", "test@wp.pl", "Katowice", -11, Role.MENTOR);
        });
    }

    @Test
    public void testNullNameIllegalArgumentsThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new User(null, "Kowalski", "www", "Katowice", 1, Role.MENTOR);
        });
    }

}