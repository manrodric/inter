CREATE TABLE cliente(
   id INT NOT NULL AUTO_INCREMENT,
   nombre VARCHAR(20) NOT NULL,
   apellido VARCHAR(20) NOT NULL,
   edad INT NOT NULL,
   fecha_nacimiento DATE NOT NULL,
   fecha_probable_muerte DATE NULL,
   PRIMARY KEY (id)
);