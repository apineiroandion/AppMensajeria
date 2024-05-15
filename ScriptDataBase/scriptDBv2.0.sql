CREATE TABLE users (
                       userName VARCHAR(20) PRIMARY KEY,
                       firstName VARCHAR(20),
                       surName VARCHAR(50),
                       password VARCHAR(50) -- Aumenté la longitud para la contraseña
);

CREATE TABLE conversacion (
                              codigoConversacion SERIAL PRIMARY KEY
);

CREATE TABLE tienen (
                        codigoConversacion INT,
                        userName VARCHAR(20),
                        PRIMARY KEY (codigoConversacion, userName),
                        FOREIGN KEY (codigoConversacion) REFERENCES conversacion(codigoConversacion),
                        FOREIGN KEY (userName) REFERENCES users(userName)
);

CREATE TABLE mensaje (
                         n SERIAL PRIMARY KEY,
                         userName VARCHAR(20),
                         fecha DATE,
                         contenido VARCHAR(250),
                         codigoConversacion INT,
                         FOREIGN KEY (userName) REFERENCES users(userName),
                         FOREIGN KEY (codigoConversacion) REFERENCES conversacion(codigoConversacion)
);