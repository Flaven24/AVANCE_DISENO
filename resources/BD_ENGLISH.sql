--LA BASE DE DATOS SE DEBE LLAMAR "calificame"

CREATE SEQUENCE public.sq_university START 1 INCREMENT 1;
CREATE TABLE university(
iduniversity int default nextval('public.sq_university') primary key,
cname varchar,
cwebpage varchar,
dregist timestamp without time zone,
bactive boolean
);
 
CREATE SEQUENCE public.sq_branch START 1 INCREMENT 1;
CREATE TABLE branch(
idbranch int default nextval('public.sq_branch') primary key,
cname varchar,
ccity varchar,
iduniversity int,
dregist timestamp without time zone,
bactive boolean,
CONSTRAINT fk_university FOREIGN KEY(iduniversity) REFERENCES public.university(iduniversity)
);

CREATE SEQUENCE public.sq_career START 1 INCREMENT 1;
CREATE TABLE career(
idcareer int default nextval('public.sq_career') primary key,
cname varchar,
iduniversity int,
dregist timestamp without time zone,
bactive boolean,
CONSTRAINT fk_university FOREIGN KEY(iduniversity) REFERENCES public.university(iduniversity)
);

CREATE SEQUENCE public.sq_course START 1 INCREMENT 1;
CREATE TABLE course(
idcourse int default nextval('public.sq_course') primary key,
cname varchar,
nsemester int,
idcareer int,
dregist timestamp without time zone,
bactive boolean,
CONSTRAINT fk_career FOREIGN KEY(idcareer) REFERENCES public.career(idcareer)
);

CREATE SEQUENCE public.sq_professor START 1 INCREMENT 1;
CREATE TABLE professor(
idprofessor int default nextval('public.sq_professor') primary key,
cname varchar,
clastname varchar,
dregist timestamp without time zone,
bactive boolean
); 

CREATE SEQUENCE public.sq_detail_course_professor START 1 INCREMENT 1;
CREATE TABLE detail_course_professor(
iddetail int default nextval('public.sq_detail_course_professor') primary key,
idcourse int,
idprofessor int,
dregist timestamp without time zone,
CONSTRAINT fk_course FOREIGN KEY(idcourse) REFERENCES public.course(idcourse),
CONSTRAINT fk_professor FOREIGN KEY(idprofessor) REFERENCES public.professor(idprofessor)
);
 
CREATE SEQUENCE public.sq_detail_university_professor START 1 INCREMENT 1;
CREATE TABLE detail_university_professor(
iddetail int default nextval('public.sq_detail_university_professor') primary key,
iduniversity int,
idprofessor int,
dregist timestamp without time zone,
CONSTRAINT fk_university FOREIGN KEY(iduniversity) REFERENCES public.university(iduniversity),
CONSTRAINT fk_professor FOREIGN KEY(idprofessor) REFERENCES public.professor(idprofessor)
);

CREATE SEQUENCE public.sq_clarity_status START 1 INCREMENT 1;
CREATE TABLE clarity_status(
idclarity int default nextval('public.sq_clarity_status') primary key,
cstatus varchar
);

CREATE SEQUENCE public.sq_difficulty_status START 1 INCREMENT 1;
CREATE TABLE difficulty_status(
iddifficulty int default nextval('public.sq_difficulty_status') primary key,
cstatus varchar
);

CREATE SEQUENCE public.sq_rating START 1 INCREMENT 1;
CREATE TABLE rating(
idrating int default nextval('public.sq_rating') primary key,
ccomment varchar,
idclarity int,
iddifficulty int,
brecommendation boolean,
dregist timestamp without time zone,
CONSTRAINT fk_clarity FOREIGN KEY(idclarity) REFERENCES public.clarity_status(idclarity),
CONSTRAINT fk_difficulty FOREIGN KEY(iddifficulty) REFERENCES public.difficulty_status(iddifficulty)
);

CREATE SEQUENCE public.seq_role START 1 INCREMENT 1;
CREATE TABLE public.role(
idrole int default nextval('public.seq_role') primary key,
cname varchar,
dregist timestamp without time zone
);


CREATE SEQUENCE public.seq_user START 1 INCREMENT 1;
CREATE TABLE public.user(
iduser int default nextval('public.seq_user') primary key,
cname varchar,
cemail varchar,
cusername varchar,
cpassword varchar,
idrole int,
dregist timestamp without time zone,
CONSTRAINT fk_role FOREIGN KEY(idrole) REFERENCES public.role(idrole)
);
