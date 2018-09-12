package com.codecool.queststore.DAO;

import org.junit.jupiter.api.Test;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class WalletDAOTest {


    WalletDAO walletDAO = new WalletDAO();


    @Test
    void testIfgetWalletExceptGroupArtifactsThrowsExceptionForInvalidId(){
        assertThrows(SQLException.class, () -> walletDAO.getWalletExceptGroupArtifacts(-1));
    }

    @Test
    void testIfGetWalletGroupExpencesThrowsExceptionForInvalidID(){
        assertThrows(SQLException.class, () -> walletDAO.getWalletGroupExpences(-1));
    }


}