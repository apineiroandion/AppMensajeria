package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserControllerTest {

    @Test
    public void testIniciarApp() {
        assertDoesNotThrow(() -> UserController.iniciarApp());
    }

    @Test
    public void testOpenLoginWindow() {
        assertDoesNotThrow(() -> UserController.openLoginWindow());
    }

    @Test
    public void testOpenRegisterWindow() {
        assertDoesNotThrow(() -> UserController.openRegisterWindow());
    }

    @Test
    public void testOpenSearchWindow() {
        assertDoesNotThrow(() -> UserController.openSearchWindow());
    }
}