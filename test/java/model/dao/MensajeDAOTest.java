package model.dao;

import model.Conversacion;
import model.Mensaje;
import model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MensajeDAOTest {

    @Test
    public void testInsertMensajeIntoDB() {
        User user = new User("test", "test", "test", "test");
        Mensaje mensaje = new Mensaje("Hola mundo", user);
        Conversacion conversacion = new Conversacion(12, new ArrayList<>());

        assertDoesNotThrow(() -> MensajeDAO.insertMensajeIntoDB(mensaje, conversacion));
    }

    @Test
    public void testGetMensajesFromDB() {
        assertDoesNotThrow(() -> {
            ArrayList<Mensaje> mensajes = MensajeDAO.getMensajesFromDB(12);
            assertNotNull(mensajes);
        });
    }
}