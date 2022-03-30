create table Usuarios(
id_Usuario INT IDENTITY (1,1),
Nombre CHAR(100) NOT NULL,
Correo CHAR NOT NULL,
Pass VARBINARY(8000) NOT NULL,
);
create table Administradores(
id_Cedula INT NOT NULL,
id_Usuario INT NOT NULL,

);
create table Prueba(
id_prueba INT IDENTITY(1,1),
Nombre CHAR NOT NULL,
Descripcion text NOT NULL,
);
create table Pregunta(
id_pregunta INT IDENTITY (1,1),
id_prueba INT NOT NULL,
Enunciado text NOT NULL,
);
create table Respuestas(
id_respuestas INT IDENTITY(1,1),
id_Pregunta INT NOT NULL,
Opcion text NOT NULL,
);