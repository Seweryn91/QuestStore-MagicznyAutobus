package com.codecool.queststore.DAO;

import com.codecool.queststore.model.Login;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MentorDAOTest {

    private MentorDAO mentorDAO = new MentorDAO();
    private User user = new User("testname","testsurname","testemail","testadress",10, Role.MENTOR);
    private Login login = new Login("testlogin","testpassword");


    @Test
    void testAddingExistingMentor() throws SQLException {
        boolean created = false;
        mentorDAO.createMentor(user,login);

        created = mentorDAO.createMentor(user,login);


        assertFalse(created);
    }

}