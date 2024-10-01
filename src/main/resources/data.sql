-- insersion de jardineros de ejemplo
insert into jardinero (nombre, especialidad, email) values ('Juan', 'Rosas', 'juan@email.com');
insert into jardinero (nombre, especialidad, email) values ('Pedro', 'Arboles', 'pedri@email.com');
insert into jardinero (nombre, especialidad, email) values ('Maria', 'Gardenias', 'maria@email.com');
insert into jardinero (nombre, especialidad, email) values ('Luis', 'Orquideas', 'luis@email.com');

-- insersion de Prospectos de ejemplo
insert into prospecto (nombre, cantidad, unidad) values ('Tierra', 5.0, 'KG');
insert into prospecto (nombre, cantidad, unidad) values ('Semillas', 10.0, 'KG');
insert into prospecto (nombre, cantidad, unidad) values ('Macetas', 20.0, 'Piezas');
insert into prospecto (nombre, cantidad, unidad) values ('Fertilizante', 2.0, 'Litros');
insert into prospecto (nombre, cantidad, unidad) values ('Herramientas', 1.0, 'Piezas');

--insersiondePlantasdeejemplo
insert into planta(especie,color_hojas,fecha_plantacion,jardinero_id)values('Rosa','Rojo','2020-01-01',1);
insert into planta(especie,color_hojas,fecha_plantacion,jardinero_id)values('Orquidea','Blanco','2020-01-01',2);
insert into planta(especie,color_hojas,fecha_plantacion,jardinero_id)values('Gardenia','Blanco','2020-01-01',3);

--insersiondePlantasconprospectosdeejemplo
insert into planta_prospecto(planta_id,prospecto_id)values(1,1);
insert into planta_prospecto(planta_id,prospecto_id)values(1,2);
