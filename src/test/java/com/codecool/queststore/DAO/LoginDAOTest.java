package com.codecool.queststore.DAO;

import com.codecool.queststore.model.Login;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoginDAOTest {
    LoginDAO logDAO = new LoginDAO();

    @Mock
    private Login login;

    @Test
    void testValidationGoodInput() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(login.getLOGIN()).thenReturn("admin");
        when(login.getPASSWORD()).thenReturn("123");

        int result = logDAO.validation(login);
        assertEquals(1,result);
    }


    @Test
    void testValidationWrongInput() throws SQLException {
        MockitoAnnotations.initMocks(this);
        when(login.getLOGIN()).thenReturn("admin");
        when(login.getPASSWORD()).thenReturn("000");

        int result = logDAO.validation(login);
        assertEquals(0,result);
    }


}