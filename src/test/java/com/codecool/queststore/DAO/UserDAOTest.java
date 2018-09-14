package com.codecool.queststore.DAO;

import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserDAOTest {

    private static UserDAO userDAO;
    private static Connection mockConnection;
    private static PreparedStatement mockStatement;
    private static ResultSet mockResultSet;


    @BeforeAll
    static void initAll() {
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        userDAO = new UserDAO(mockConnection);
    }

    @Test
    void testDeleteUser() throws SQLException {

        when(mockConnection.prepareStatement("SELECT deleteUser(?)")).thenReturn(mockStatement);

        userDAO.deleteUser(13);
        verify(mockStatement).setInt(1,13);
    }

    @Test
    void testGetUser() throws SQLException {

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        doNothing().when(mockStatement).setInt(anyInt(), anyInt());
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(anyInt())).thenReturn("Adam", "Kowalski", "test@wp.pl", "Katowice", "mentor");

        User output = userDAO.getUser(anyInt());

        assertEquals("Adam", output.getNAME());
        assertEquals("Kowalski", output.getSURNAME());
        assertEquals("test@wp.pl", output.getEMAIL());
        assertEquals(Role.MENTOR, output.getROLE());
    }

    @Test
    void testGetUserWithNullEmail() throws SQLException {

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(anyInt())).thenReturn("Adam", "Kowalski", null, "Katowice", "mentor");

        User output = userDAO.getUser(anyInt());
        assertNull(output);
    }

    @Test
    void testUpdateUserEmail() throws SQLException {

        when(mockConnection.prepareStatement("SELECT updateEmail(?, ?)")).thenReturn(mockStatement);

        userDAO.updateEmail(22, "test");

        verify(mockStatement).setInt(1,22);
        verify(mockStatement).setString(2,"test");

    }

    @Test
    void testUpdateUserAddress() throws SQLException {

        when(mockConnection.prepareStatement("SELECT updateAddress(?, ?)")).thenReturn(mockStatement);

        userDAO.updateAddress(6, "New York");

        verify(mockStatement).setInt(1,6);
        verify(mockStatement).setString(2,"New York");

    }
}


