package com.codecool.queststore.controller.server.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.HttpCookie;

import static org.junit.jupiter.api.Assertions.*;

public class ClassServiceTest {

    @Mock
    private HttpCookie httpCookie;

    @Mock
    private String path;

    @InjectMocks
    private ClassService classService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


}