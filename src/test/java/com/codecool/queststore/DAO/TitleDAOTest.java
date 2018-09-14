package com.codecool.queststore.DAO;

import com.codecool.queststore.model.Title;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class TitleDAOTest {

    TitleDAO titleDAO = new TitleDAO();

    @Test
    void testIfCreateTitleThrowsExceptionForNullArgument(){
        assertThrows(SQLException.class, () -> titleDAO.createTitle(null));
    }

    @Test
    void testIfCreateTitleThrowsExceptionForEmptyStringArgument(){
        assertThrows(SQLException.class, () -> titleDAO.createTitle(""));
    }

    @Test
    void testIfCreateTitleReturnsFalseForNullArgument() throws SQLException{
        assertFalse(titleDAO.createTitle(null));
    }

    @Test
    void testIfCreateTitleReturnsFalseForEmptyStringArgument() throws SQLException{
        assertFalse(titleDAO.createTitle(""));
    }

}