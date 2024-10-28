CREATE DATABASE AppAgricola;

USE AppAgricola;

CREATE TABLE Usuario (
id INT PRIMARY KEY NOT NULL,
apellido VARCHAR(35) NOT NULL,
nombre VARCHAR(35) NOT NULL,
documento INT NOT NULL,
telefono VARCHAR(35),
email VARCHAR(35)
);

INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (1, 'MOLL', 'MATIAS', 39843765, '154629363', 'mollm96@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (2, 'MARADONA', 'DIEGO', 14276579, '154002211', 'lamanoded10s@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (3, 'MESSI', 'LIONEL', 33016244, '154112233', 'el10deARG@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (4, 'DI MARIA', 'ANGEL', 34099721, '154223311', 'fideoArg@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (5, 'OTAMENDI', 'NICOLAS', 34151615, '154121221', 'otanico12@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (6, 'MARTINEZ', 'EMILIANO', 37284001, '154312111', 'MQTC26@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (7, 'DE PAUL', 'RODRIGO', 26535488, '154663322', 'DPRod94@gmail.com');
INSERT INTO Usuario (id, apellido, nombre, documento, telefono, email) VALUES (8, 'ALVAREZ', 'JULIAN', 40178846, '154992233', 'JALVAREZ9@gmail.com');

SELECT id, apellido, nombre, documento, telefono, email FROM Usuario WHERE id = 1;
UPDATE Usuario SET apellido = 'MOLL' WHERE id = 1;
SELECT id, apellido, nombre, documento, telefono, email FROM Usuario;
DELETE FROM Usuario WHERE id = 1;

CREATE TABLE Productor(
id INT PRIMARY KEY NOT NULL,
apellido VARCHAR(35) NOT NULL,
nombre VARCHAR(35) NOT NULL,
telefono VARCHAR(35),
email VARCHAR(35),
ubicacion VARCHAR (35),
Usuario_id INT
FOREIGN KEY (Usuario_id) REFERENCES Usuario(id)
);

INSERT INTO Productor (id, apellido, nombre, telefono, email, Usuario_id) VALUES (1, 'MARADONA', 'DIEGO', '154002211', 'lamanoded10s@gmail.com', 'Buenos Aires', 2);
INSERT INTO Productor (id, apellido, nombre, telefono, email, Usuario_id) VALUES (2, 'MESSI', 'LIONEL', '154112233', 'el10deARG@gmail.com', 'Barcelona', 3);

SELECT id, apellido, nombre, telefono, email, Usuario_id FROM Productor WHERE id = 1;
UPDATE Productor SET apellido = 'MARADONA' WHERE id = 1;
SELECT id, apellido, nombre, documento, telefono, email FROM Productor;
DELETE FROM Productor WHERE id = 1;

CREATE TABLE Cliente(
id INT PRIMARY KEY NOT NULL,
apellido VARCHAR(35) NOT NULL,
nombre VARCHAR(35) NOT NULL,
telefono VARCHAR(35),
email VARCHAR(35),
Usuario_id INT
FOREIGN KEY (Usuario_id) REFERENCES Usuario(id)
);

INSERT INTO Cliente (id, apellido, nombre, telefono, email, Usuario_id) VALUES (1, 'DI MARIA', 'ANGEL', '154223311', 'fideoArg@gmail.com', 3);
INSERT INTO Cliente (id, apellido, nombre, telefono, email, Usuario_id) VALUES (2, 'OTAMENDI', 'NICOLAS', '154121221', 'otanico12@gmail.com', 4);

SELECT id, apellido, nombre, telefono, email, Usuario_id INT FROM Cliente WHERE id = 1;
UPDATE Cliente SET apellido = 'DI MARIA' WHERE id = 1;
SELECT id, apellido, nombre, documento, telefono, email FROM Cliente;
DELETE FROM Productor WHERE id = 1;

CREATE TABLE Trabajador(
id INT PRIMARY KEY NOT NULL,
apellido VARCHAR(35) NOT NULL,
nombre VARCHAR(35) NOT NULL,
fecha_contratacion DATE,
telefono VARCHAR(35),
email VARCHAR(35),
Parcela_id INT,
FOREING KEY (Parcela_id) REFERENCES Parcela (id)
);

INSERT INTO Trabajador VALUES (1, 'MARTINEZ', 'EMILIANO', 2024-10-1, '154312111', 'MQTC26@gmail.com', 1);
INSERT INTO Trabajador VALUES (2, 'DE PAUL', 'RODRIGO', 2024-10-1,'154663322', 'DPRod94@gmail.com', 2);
INSERT INTO Trabajador VALUES (3, 'ALVAREZ', 'JULIAN', 2024-10-1,'154992233', 'JALVAREZ9@gmail.com', 2);

SELECT id, apellido, nombre, telefono, email, Parcela_id FROM Trabajador WHERE id = 1;
UPDATE Trabador SET apellido = 'MARTINEZ' WHERE id = 1;
SELECT id, apellido, nombre, telefono, email, Parcela_id FROM Trabajador;
DELETE FROM Trabajador WHERE id = 1;

CREATE TABLE Parcela(
id INT PRIMARY KEY NOT NULL,
ubicacion VARCHAR (35),
Productor_id INT,
Cultivo_id INT,
Trabajador_id INT,
FOREIGN KEY (Productor_id) REFERENCES Productor (id),
FOREIGN KEY (Cultivo_id) REFERENCES Cultivo (id),
FOREIGN KEY (Trabajador_id) REFERENCES Trabajador (id)
);

INSERT INTO Parcela (id, ubicacion, Productor_id, Cultivo_id, Trabajador_id) VALUES (1, 'FINCA LOS COMPARTOS', 2, 3, 1);
INSERT INTO Parcela (id, ubicacion, Productor_id, Cultivo_id, Trabajador_id) VALUES (2, 'FINCA NUEVO AMANECER', 1, 1, 2);
INSERT INTO Parcela (id, ubicacion, Productor_id, Cultivo_id, Trabajador_id) VALUES (3, 'FINCA DOÑA MARIA', 2, 2, 3);

SELECT id, ubicacion, Productor_id, Cultivo_id, Trabajador_id FROM Parcela WHERE id = 1;
UPDATE Parcela SET ubicación = 'FINCA LOS COMPARTOS' WHERE id = 1;
SELECT id, ubicacion, Productor_id, Cultivo_id, Trabajador_id FROM Parcela;
DETELE FROM Parcela WHERE id = 1;

CREATE TABLE Cultivos (
id INT PRIMARY KEY NOT NULL,
tipo VARCHAR(35),
fecha_plantacion DATE,
fecha_cosecha DATE,
Productor_id INT,
Parcela_id INT,
FOREIGN KEY (Productor_id) REFERENCES Productor (id),
FOREIGN KEY (Parcela_id) REFERENCES Parcela (id)
);

INSERT INTO Cultivos (id, tipo, fecha_plantacion, fecha_cosecha, Productor_ id, Parcela_id) VALUES (1, 'TOMATE', 2024-01-07, 2024-10-07, 1, 1);
INSERT INTO Cultivos (id, tipo, fecha_plantacion, fecha_cosecha, Productor_ id, Parcela_id) VALUES (2, 'CIRUELA', 2024-01-06, 2024-10-06, 2, 2);
INSERT INTO Cultivos (id, tipo, fecha_plantacion, fecha_cosecha, Productor_ id, Parcela_id) VALUES (3, 'UVA', 2024-01-05, 2024-10-05, 2, 3);

SELECT id, tipo, fecha_plantacion, fecha_cosecha, Productor_ id, Parcela_id FROM Cultivos WHERE id = 1;
UPDATE Cultivos SET tipo WHERE tipo = 'TOMATE' id = 1;
SELECT id, tipo, fecha_plantacion, fecha_cosecha, Productor_ id, Parcela_id FROM Cutivos;
DELETE Cutivos FROM WHERE id = 1;

CREATE TABLE Item (
id INT PRIMARY KEY NOT NULL,
categoria VARCHAR(35),
descripcion VARCHAR(500),
precio DECIMAL (10, 2),
fecha_elaboracion DATE,
Productor_id INT,
FOREIGN KEY (Productor_id) REFERENCES Productor (id)
);

INSERT INTO Item (id, categoria, descripcion, precio, fecha_elaboración, Productor_id) VALUES (1, 'VINO', 'Vino de cosecha de selección, sello: finca Doña maria', '12111,00', 2024-10-1, 1 );
INSERT INTO Item (id, categoria, descripcion, precio, fecha_elaboración, Productor_id) VALUES (2, 'MIEL', 'Miel de abeja natural, traida a ustedes desde finca Los Compartos', '7000,00', 2024-10-1, 2);
INSERT INTO Item (id, categoria, descripcion, precio, fecha_elaboración, Productor_id) VALUES (3, 'TOMATES ENVASADOS','Productos Artesanales', '¡Los mejores tomates que probaras!', '8500,00', 2024-10-1, 2 );

SELECT id, categoria, descripcion, precio, fecha_elaboración, Productor_id FROM Item WHERE id = 1;
UPDATE Item SET Categoria = 'VINO'WHERE id = 1;
SELECT id, categoria, descripcion, precio, fecha_elaboración, Productor_id FROM Item;
DELETE FROM Item WHERE id = 1;

CREATE TABLE Pedido (
id INT PRIMARY KEY NOT NULL,
fecha_pedido DATE,
cantidad INT,
pago DECIMAL (10, 2),
Cliente_id INT,
Productor_id INT,
Item_id INT,
FOREIGN KEY (Cliente_id) REFERENCES Cliente (id),
FOREIGN KEY (Productor_id) REFERENCES Productor (id),
FOREIGN KEY (Item_id) REFERENCES Item (id)
);

INSERT INTO Pedido (id, fecha_pedido, cantidad, pago, Cliente_id, Productor_id, Item_id) VALUES (1, 2024-10-06, 3, '36333,00', 1, 1, 1);
INSERT INTO Pedido (id, fecha_pedido, cantidad, pago, Cliente_id, Productor_id, Item_id) VALUES (2, 2024-10-06, 5, '42500', 2, 2, 3);

SELECT id, fecha_pedido, cantidad, pago, Cliente_id, Productor_id, Item_id FROM Pedido WHERE id = 1;
UPDATE Pedido SET fecha_pedido =2024-10-06 WHERE id = 1;
SELECT id, fecha_pedido, cantidad, pago, Cliente_id, Productor_id, Item_id FROM Pedido;
DELETE FROM Pedido WHERE id = 1;

DROP DATABASE AppAgricola;

