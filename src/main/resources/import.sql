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


INSERT INTO animals (region_id,specie_id,name,birth_date,sex,color, weight, description) VALUES(12,1,'Gastón','2018-10-01','Macho', 'blanco', 6, 'Bueno con otros perros. Cauteloso con extraños. Tímido. Le gusta estar en compañía. Cariñoso. Dormilón');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex,color, weight, description) VALUES(5,1,'Tila','2006-06-15','Hembra', 'canela', 12, 'Perrita muy tranquila, juguetona, sociable con los demás, perros, gatos, personas adultas y niños, muy respetuosa con todos y amante de la familia aunque también muy independiente');
INSERT INTO animals (region_id,specie_id,name,birth_date,sex,color, weight, description) VALUES(8,1,'Lisa','2014-07-06','Hembra', 'canela', 40, 'Bueno con perros y niños. Cauteloso con extraños. Bueno en el coche y en casa. A veces ladra. Le gusta pasear. Tímida. Le gusta estar en compañía. Cariñosa, juguetóna y dormilóna');

INSERT INTO users(username,password,enabled) VALUES('barbara','$2a$10$zMOyr8ALWbjes2qfVSCFAO4/t6FcBQExJn1Ko12awQoZCMwoDpTOe',1);
INSERT INTO users (username,password,enabled) VALUES('maria','$$2a$10$ctMbe2DPFbVhPqPR7xnUdeynqFNRwQdzSPNS3YaxuoRXOv7GpCPqS',1);

INSERT INTO roles (name) VALUES('ROLE_USER');
INSERT INTO roles (name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles (user_id,role_id) VALUES(1,1);
INSERT INTO userss_roles (user_id,role_id) VALUES(2,2);
