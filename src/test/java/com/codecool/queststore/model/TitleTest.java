package com.codecool.queststore.model;

import org.junit.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

public class TitleTest {

    @Test
    public void testConstructorWithNullIDValue() {
        assertThrows(IllegalArgumentException.class, () -> new Title(null, "name"));
    }

    @Test
    public void testConstructorWithNegativeIDValue() {
        assertThrows(IllegalArgumentException.class, () -> new Title(-1, "name"));
    }

    @Test
    public void testConstructorWithNullNameValue() {
        assertThrows(IllegalArgumentException.class, () -> new Title(1, null));
    }

}