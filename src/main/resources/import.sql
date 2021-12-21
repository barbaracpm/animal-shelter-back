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




INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description, picture) VALUES(12,1,'Gastón','2018-10-01',1, 'blanco', 6, 'Bueno con otros perros. Cauteloso con extraños. Tímido. Le gusta estar en compañía. Cariñoso. Dormilón', 'https://t1.ea.ltmcdn.com/es/images/6/8/4/img_consejos_para_mantener_el_pelo_blanco_de_mi_perro_22486_600.jpg');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description, picture) VALUES(5,1,'Tila','2006-06-15',2, 'canela', 12, 'Perrita muy tranquila, juguetona, sociable con los demás, perros, gatos, personas adultas y niños, muy respetuosa con todos y amante de la familia aunque también muy independiente', 'https://cdn01.diarimes.com/uploads/imagenes/10col/2020/03/02/_img20200218154603_9ff986e1.jpg?ecac8079565fec3abb5ba1d946802b25');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description, picture) VALUES(7,2,'Luna','2016-08-12',2, 'negro', 4, 'Gata simpática y tranquila','https://as01.epimg.net/us/imagenes/2021/08/17/tikitakas/1629222058_164862_1629222395_noticia_normal.jpg' );
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description, picture) VALUES(9,2,'Simón','2020-06-01',2, 'anaranjado', 8, 'amigo de sus amigos', 'http://mascotafiel.com/wp-content/uploads/2016/10/que-raza-son-los-gatos-naranja.jpg');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex_id,color, weight, description, picture) VALUES(6,1,'Ronaldo','2019-12-04',2, 'blanco y negro', 20, 'Perro fiel y bondadoso', 'data:image/jpeg;base64,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');





INSERT INTO users(username,password,enabled) VALUES('barbara','$2a$10$zMOyr8ALWbjes2qfVSCFAO4/t6FcBQExJn1Ko12awQoZCMwoDpTOe',1);
INSERT INTO users (username,password,enabled) VALUES('maria','$$2a$10$ctMbe2DPFbVhPqPR7xnUdeynqFNRwQdzSPNS3YaxuoRXOv7GpCPqS',1);


INSERT INTO roles (name) VALUES('ROLE_USER');
INSERT INTO roles (name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles (user_id,role_id) VALUES(1,1);
INSERT INTO users_roles (user_id,role_id) VALUES(2,2);

