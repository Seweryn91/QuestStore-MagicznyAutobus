package com.codecool.queststore.controller.server.httphandler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class StudentsHandlerTest {

    //@Spy
    static StudentsHandler studentHandler;

    @BeforeAll
    static void initAll() {

        studentHandler = spy(new StudentsHandler());
    }

    @Test
    void testHandleWhenRequestMethodIsPost() throws Exception {

        HttpExchange httpExchange = mock(HttpExchange.class);
        when(httpExchange.getRequestMethod()).thenReturn("POST");

        doNothing().when(studentHandler).handlePost(httpExchange);
        doNothing().when(studentHandler).handleSession(httpExchange);

        studentHandler.handle(httpExchange);
        verify(studentHandler).handlePost(httpExchange);
    }

    @Test
    void testHandleWhenRequestMethodIsGet() throws Exception {

        HttpExchange httpExchange = mock(HttpExchange.class);
        when(httpExchange.getRequestMethod()).thenReturn("GET");

        doNothing().when(studentHandler).handleSession(httpExchange);
        doNothing().when(studentHandler).handlePost(httpExchange);

        studentHandler.handle(httpExchange);
        verify(studentHandler).handleSession(httpExchange);
    }

    @Test
    void testHandleSessionWhenCookieIsNull() throws Exception {

        Headers headers = new Headers();
        HttpExchange httpExchange = spy(HttpExchange.class);

        when(httpExchange.getRequestHeaders()).thenReturn(headers);

        doNothing().when(studentHandler).redirect(httpExchange, "/");
        studentHandler.handleSession(httpExchange);
        verify(studentHandler).redirect(httpExchange, "/");
    }

    @Test
    void testHandleSessionWhenCookieIsNotValid() throws Exception {

        Headers headers = new Headers();
        headers.add("Cookie", "test");
        HttpExchange httpExchange = spy(HttpExchange.class);

        when(httpExchange.getRequestHeaders()).thenReturn(headers);

        doNothing().when(studentHandler).redirect(httpExchange, "/");
        studentHandler.handleSession(httpExchange);
        verify(studentHandler).redirect(httpExchange, "/");
    }

}

