package com.codecool.queststore.model.classes;

import com.codecool.queststore.model.user.User;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CodecoolClassTest {

    @Test
    public void testConstructorWithNegativeIDValue() {
        assertThrows(IllegalArgumentException.class, () -> new CodecoolClass(-1, "className", new ArrayList<User>(), new ArrayList<User>()));
    }

    @Test
    public void testConstructorWithNullNameValue() {
        assertThrows(IllegalArgumentException.class, () -> new CodecoolClass(1, null, new ArrayList<User>(), new ArrayList<User>()));
    }

    @Test
    public void testConstructorWithNullAsMentorsList() {
        assertThrows(IllegalArgumentException.class, () -> new CodecoolClass(1, "className", null, new ArrayList<User>()));
    }

    @Test
    public void testConstructorWithNullAsStudentList() {
        assertThrows(IllegalArgumentException.class, () -> new CodecoolClass(1, "className", new ArrayList<User>(), null));
    }

    @Test
    public void testOverloadedConstructorWithNullNameValue() {
        assertThrows(IllegalArgumentException.class, () -> new CodecoolClass(null));
    }
}