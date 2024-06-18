CREATE SEQUENCE public.sq_universidad START 1 INCREMENT 1;
CREATE TABLE universidad(
iduniversidad int default nextval('public.sq_universidad') primary key,
cnombre varchar,
cpaginaweb varchar,
dfecreg timestamp without time zone,
bactivo boolean
);
 
CREATE SEQUENCE public.sq_sucursal START 1 INCREMENT 1;
CREATE TABLE sucursal(
idsucursal int default nextval('public.sq_sucursal') primary key,
cnombre varchar,
cciudad varchar,
iduniversidad int,
dfecreg timestamp without time zone,
bactivo boolean,
CONSTRAINT fk_universidad FOREIGN KEY(iduniversidad) REFERENCES public.universidad(iduniversidad)
);

CREATE SEQUENCE public.sq_carrera START 1 INCREMENT 1;
CREATE TABLE carrera(
idcarrera int default nextval('public.sq_carrera') primary key,
cnombre varchar,
iduniversidad int,
dfecreg timestamp without time zone,
bactivo boolean,
CONSTRAINT fk_universidad FOREIGN KEY(iduniversidad) REFERENCES public.universidad(iduniversidad)
);

CREATE SEQUENCE public.sq_curso START 1 INCREMENT 1;
CREATE TABLE curso(
idcurso int default nextval('public.sq_curso') primary key,
cnombre varchar,
nsemestre int,
idcarrera int,
dfecreg timestamp without time zone,
bactivo boolean,
CONSTRAINT fk_carrera FOREIGN KEY(idcarrera) REFERENCES public.carrera(idcarrera)
);

CREATE SEQUENCE public.sq_docente START 1 INCREMENT 1;
CREATE TABLE docente(
iddocente int default nextval('public.sq_docente') primary key,
cnombre varchar,
capellido varchar,
dfecreg timestamp without time zone,
bactivo boolean
); 

CREATE TABLE cruce_curso_docente(
idcurso int,
iddocente int,
dfecreg timestamp without time zone,
CONSTRAINT fk_curso FOREIGN KEY(idcurso) REFERENCES public.curso(idcurso),
CONSTRAINT fk_docente FOREIGN KEY(iddocente) REFERENCES public.docente(iddocente)
);
 
CREATE TABLE cruce_universidad_docente(
iduniversidad int,
iddocente int,
dfecreg timestamp without time zone,
CONSTRAINT fk_universidad FOREIGN KEY(iduniversidad) REFERENCES public.universidad(iduniversidad),
CONSTRAINT fk_docente FOREIGN KEY(iddocente) REFERENCES public.docente(iddocente)
);

CREATE SEQUENCE public.sq_estado_claridad START 1 INCREMENT 1;
CREATE TABLE estado_claridad(
idclaridad int default nextval('public.sq_estado_claridad') primary key,
cestado varchar
);

CREATE SEQUENCE public.sq_estado_dificultad START 1 INCREMENT 1;
CREATE TABLE estado_dificultad(
iddificultad int default nextval('public.sq_estado_dificultad') primary key,
cestado varchar
);

CREATE SEQUENCE public.sq_calificacion START 1 INCREMENT 1;
CREATE TABLE calificacion(
idcalificacion int default nextval('public.sq_calificacion') primary key,
ccomentario varchar,
idclaridad int,
iddificultad int,
brecomendacion boolean,
dfecreg timestamp without time zone,
CONSTRAINT fk_claridad FOREIGN KEY(idclaridad) REFERENCES public.estado_claridad(idclaridad),
CONSTRAINT fk_dificultad FOREIGN KEY(iddificultad) REFERENCES public.estado_dificultad(iddificultad)
);
