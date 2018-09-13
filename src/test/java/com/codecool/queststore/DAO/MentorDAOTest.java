package com.codecool.queststore.DAO;

import com.codecool.queststore.model.Login;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MentorDAOTest {

    private MentorDAO mentorDAO = new MentorDAO();
    private User user = new User("testname","testsurname","testemail","testadress",10, Role.MENTOR);
    private Login login = new Login("testlogin","testpassword");


    @Test
    void testAddingExistingMentor(){
        boolean created = false;

        try{
            created = mentorDAO.createMentor(user,login);
        }catch(Exception e){
            e.printStackTrace();
        }

        assertFalse(created);
    }

}