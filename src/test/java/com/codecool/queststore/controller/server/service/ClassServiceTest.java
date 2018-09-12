package com.codecool.queststore.controller.server.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.HttpCookie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ClassServiceTest {

    private ClassService classService;

    @BeforeEach
    public void setUp() {
        HttpCookie mockHttpCookie = mock(HttpCookie.class);
        String path = "";
        this.classService = new ClassService(mockHttpCookie, path);
    }

    @Test
    public void testIfCastableToIntWithNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> classService.isStringCastableToInt(null));
    }
}