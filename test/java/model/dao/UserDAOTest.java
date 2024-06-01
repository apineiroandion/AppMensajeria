package model.dao;

import model.User;
import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    private ArrayList<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        User user1 = new User("user1", "John", "Doe", "password1");
        User user2 = new User("user2", "Jane", "Doe", "password2");
        users.add(user1);
        users.add(user2);
    }

    @Test
    void testLoggin() {
        User user1 = users.get(0);
        User user2 = users.get(1);
        UserModel.addUser(user1);
        UserModel.addUser(user2);
        assertTrue(UserModel.loggin("user1", "password1"));
        assertFalse(UserModel.loggin("user1", "wrongpassword"));
        assertFalse(UserModel.loggin("nonexistentuser", "password"));
    }

    @Test
    void testGetUserByUserName() {
        assertNotEquals(users.get(0), UserModel.getUserByUserName("user1"));
        assertNull(UserModel.getUserByUserName("nonexistentuser"));
    }

    @Test
    void testNewUser() {
        User newUser = UserModel.newUser("newuser", "New", "User", "password");
        assertEquals("newuser", newUser.getUserName());
        assertEquals("New", newUser.getFirstName());
        assertEquals("User", newUser.getSurName());
        assertEquals("password", newUser.getPassword());
    }

    @Test
    void testAddUser() {
        User newUser = UserModel.newUser("newuser", "New", "User", "password");
        UserModel.addUser(newUser);
        assertTrue(UserModel.getUsers().contains(newUser));
    }


}