package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTest {
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

    @Test
    void testAddContact() {
        User user1 = users.get(0);
        User user2 = users.get(1);
        UserModel.addUser(user1);
        UserModel.addUser(user2);
        assertNotNull(user1);
        assertNotNull(user2);
        UserModel.addContact(user1, user2);
        assertTrue(user1.getContactos().contains(user2));
    }

    @Test
    void testAddConversacion() {
        User user1 = users.get(0);
        User user2 = users.get(1);
        ArrayList<User> participantes = new ArrayList<>(List.of(user1, user2));
        Conversacion conversacion = UserModel.newConversacion(1, participantes);
        UserModel.addConversacion(user1, conversacion);
        assertTrue(user1.getConversaciones().contains(conversacion));
    }

    @Test
    void testNewConversacion() {
        User user1 = users.get(0);
        User user2 = users.get(1);
        ArrayList<User> participantes = new ArrayList<>(List.of(user1, user2));
        Conversacion conversacion = UserModel.newConversacion(1, participantes);
        assertNotNull(conversacion);
        assertEquals(1, conversacion.getCodigoConversacion());
        assertNotEquals(participantes, conversacion.getParticipantes());
    }

    @Test
    void testNewMensaje() {
        User user1 = users.get(0);
        Mensaje mensaje = UserModel.newMensaje("Hello", user1);
        assertEquals("Hello", mensaje.getContenido());
        assertEquals(user1, mensaje.getEmisor());
    }

    @Test
    void testAddMensaje() {
        User user1 = users.get(0);
        User user2 = users.get(1);
        Conversacion conversacion = UserModel.newConversacion(1, new ArrayList<>(List.of(user1, user2)));
        Mensaje mensaje = UserModel.newMensaje("Hello", user1);
        assertNotNull(conversacion);
        assertNotNull(mensaje);
        UserModel.addMensaje(conversacion, mensaje);
        assertTrue(conversacion.getMensajes().contains(mensaje));
    }

    @Test
    void testGetUsers() {
        assertNotEquals(users, UserModel.getUsers());
    }

    @Test
    void testSetUsers() {
        ArrayList<User> newUsers = new ArrayList<>();
        UserModel.setUsers(newUsers);
        assertEquals(newUsers, UserModel.getUsers());
    }
}
