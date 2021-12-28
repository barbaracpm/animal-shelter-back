INSERT INTO regions (name) VALUES('Andalucía');
INSERT INTO regions (name) VALUES('Aragón');
INSERT INTO regions (name) VALUES('Principado de Asturias');
INSERT INTO regions (name) VALUES('Illes Balears');
INSERT INTO regions (name) VALUES('Canarias');
INSERT INTO regions (name) VALUES('Cantabria');
INSERT INTO regions (name) VALUES('Castilla y León');
INSERT INTO regions (name) VALUES('Castilla-La Mancha');
INSERT INTO regions (name) VALUES('Cataluña');
INSERT INTO regions (name) VALUES('Comunitat Valenciana');
INSERT INTO regions (name) VALUES('Extremadura');
INSERT INTO regions (name) VALUES('Galicia');
INSERT INTO regions (name) VALUES('Comunidad de Madrid');
INSERT INTO regions (name) VALUES('Región de Murcia');
INSERT INTO regions (name) VALUES('Comunidad Foral de Navarra');
INSERT INTO regions (name) VALUES('País Vasco');
INSERT INTO regions (name) VALUES('La Rioja');
INSERT INTO regions (name) VALUES('Ciudad Autónoma de Ceuta');
INSERT INTO regions (name) VALUES('Ciudad Autónoma de Melilla');

INSERT INTO species (name) VALUES('perro');
INSERT INTO species (name) VALUES('gato');

INSERT INTO sexs (name) VALUES('macho');
INSERT INTO sexs (name) VALUES('hembra');

INSERT INTO volunteers (name, surname, email, phone) VALUES('Pablo', 'Díaz', 'pdiaz@gmail.com', 675895566);
INSERT INTO volunteers (name, surname, email, phone) VALUES('Elena', 'Perez', 'eperez@gmail.com', 629456688);


INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description) VALUES(12,1,'Gastón','2018-10-01',1,'blanco', 6, 'Bueno con otros perros. Cauteloso con extraños. Tímido. Le gusta estar en compañía. Cariñoso. Dormilón');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description) VALUES(5,1,'Tila','2006-06-15',2,'canela', 12, 'Perrita muy tranquila, juguetona, sociable con los demás, perros, gatos, personas adultas y niños, muy respetuosa con todos y amante de la familia aunque también muy independiente');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description) VALUES(7,2,'Luna','2016-08-12',2,'negro', 4, 'Gata simpática y tranquila');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description) VALUES(9,2,'Simón','2020-06-01',2,'anaranjado', 8, 'amigo de sus amigos');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description) VALUES(6,1,'Ronaldo','2019-12-04',2,'blanco y negro', 16, 'Perro fiel y bondadoso');
INSERT INTO users(username,password,enabled) VALUES('barbara','$2a$10$zMOyr8ALWbjes2qfVSCFAO4/t6FcBQExJn1Ko12awQoZCMwoDpTOe',1);
INSERT INTO users (username,password,enabled) VALUES('maria','$$2a$10$ctMbe2DPFbVhPqPR7xnUdeynqFNRwQdzSPNS3YaxuoRXOv7GpCPqS',1);

INSERT INTO roles (name) VALUES('ROLE_USER');
INSERT INTO roles (name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles (user_id,role_id) VALUES(1,1);
INSERT INTO users_roles (user_id,role_id) VALUES(2,2);

