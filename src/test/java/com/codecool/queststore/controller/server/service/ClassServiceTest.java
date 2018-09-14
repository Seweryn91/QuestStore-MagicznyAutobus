package com.codecool.queststore.controller.server.service;

import com.codecool.queststore.DAO.ClassDAO;
import com.codecool.queststore.DAO.UserDAO;
import com.codecool.queststore.dao.interfaces.ClassDAOInterface;
import com.codecool.queststore.model.classes.CodecoolClass;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpCookie;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClassServiceTest {

    private ClassService classService;
    private HttpCookie httpCookie;

    @BeforeEach
    public void setUp() {
        HttpCookie mockHttpCookie = mock(HttpCookie.class);
        String path = "";
        this.classService = new ClassService(mockHttpCookie, path);
    }

    @Test
    public void testIfCastableToIntMethodWithNullArgument() {
        assertThrows(IllegalArgumentException.class, () -> classService.isStringCastableToInt(null));
    }

    @ParameterizedTest
    @MethodSource("generateRandomNumbers")
    public void testIfTrueWhitCastableToIntArguments(String number) {
        assertTrue(classService.isStringCastableToInt(number));
    }

    @Test
    public void testIfFalseWithUncastableToIntArgument() {
        boolean actual = classService.isStringCastableToInt("uncastableToInt");
        assertFalse(actual);
    }

    @Test
    public void testSplitingURLWithDoubleSlash() {
        int expected = 2;
        int actual = classService.splitURL("test//test").length;
        assertEquals(expected, actual);
    }

    @Test
    public void testSplitingURLThatIsSlash() {
        int expected = 0;
        int actual = classService.splitURL("////").length;
        assertEquals(expected, actual);
    }

    @Test
    void testThatClassCanBeAssigned() {
        String[] splitedPath = {"test", "test", "assign:"};
        boolean actual = classService.isAction(splitedPath);
        assertEquals(true, actual);
    }

    @Test
    void testIfClassCannotBeAssignedBecouseURLIsTooShort() {
        String[] splitedPath = {"test", "test"};
        boolean actual = classService.isAction(splitedPath);
        assertEquals(false, actual);
    }

    @Test
    void testIfClassCannotBeAssignedBecouseURLIsIncorrect() {
        String[] splitedPath = {"test", "test", "test"};
        boolean actual = classService.isAction(splitedPath);
        assertEquals(false, actual);
    }

    @Test
    void testIfClassIsAddedAtRequest() throws  NoSuchFieldException, IllegalAccessException, SQLException {
        ChangeFieldsModifiers.updateClassService(classService, "/classes/add");
        ClassDAOInterface mockCDInterface = mock(ClassDAO.class);
        this.classService.setClassDAOInterface(mockCDInterface);
        UserDAO mockUserDAO = mock(UserDAO.class);

        doNothing().when(mockUserDAO).getUser(anyInt());
        // List<CodecoolClass> mockClasses = mock(ArrayList<CodecoolClass>);
        //when(mockCDInterface.getClasses()).thenReturn();
        //when(classService.defineTarget()).thenReturn(mockClasses);

        //verify()

    }

    static Stream<String> generateRandomNumbers() {
        List<String> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i < 10; i++) {
            numbers.add(String.valueOf(random.nextInt(1000)));
        }
        return numbers.stream();
    }

    public static class ChangeFieldsModifiers {
        public static void updateClassService( final ClassService other, final String newValue ) throws NoSuchFieldException, IllegalAccessException
        {
            final Field fieldA = ClassService.class.getDeclaredField( "path" );
            fieldA.setAccessible(true);
            fieldA.set(other, newValue);
        }
    }
}