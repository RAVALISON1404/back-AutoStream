-- drop database vente_voiture;
CREATE database voiture;
\c voiture

CREATE TABLE categorie(
 idcategorie SERIAL PRIMARY KEY,
 nomcategorie VARCHAR(50)
);

CREATE TABLE continent(
 idcontinent SERIAL PRIMARY KEY,
 nomcontinent VARCHAR(50)
);

CREATE TABLE marque(
 idmarque SERIAL PRIMARY KEY,
 nommarque VARCHAR(50),
 idcontinent INT NOT NULL,
 photo text,
 FOREIGN KEY(idcontinent) REFERENCES continent(idcontinent)
);

CREATE TABLE energie(
 idenergie SERIAL PRIMARY KEY,
 nomenergie VARCHAR(50)
);

CREATE TABLE carrosserie(
 idcarrosserie SERIAL PRIMARY KEY,
 nomcarrosserie VARCHAR(50)
);

CREATE TABLE transmission(
 idtransmission SERIAL PRIMARY KEY,
 nomtransmission VARCHAR(50)
);

CREATE TABLE drivetype(
 iddrivetype SERIAL PRIMARY KEY,
 nomdrivetype VARCHAR(50)
);

CREATE TABLE conduite(
 idconduite SERIAL PRIMARY KEY,
 nomconduite VARCHAR(50)
);

CREATE TABLE type(
 idtype SERIAL PRIMARY KEY,
 nomtype VARCHAR(50)
);

CREATE TABLE modele(
 idmodele SERIAL PRIMARY KEY,
 nommodele VARCHAR(50),
 poids real,
 longueur real,
 largeur real,
 hauteur real,
 reservoire real,
 idcarrosserie INT NOT NULL,
 idcategorie INT NOT NULL,
 idmarque INT NOT NULL,
 FOREIGN KEY(idcarrosserie) REFERENCES carrosserie(idcarrosserie),
 FOREIGN KEY(idcategorie) REFERENCES categorie(idcategorie),
 FOREIGN KEY(idmarque) REFERENCES marque(idmarque)
);

create table voiture(
  idvoiture serial primary key,
  nbplace integer,
  nbporte integer,
  kilometrage real,
  cylindre real,
  puissance real,
  fumeur integer,
  datesortie date,
  idconduite integer references conduite (idconduite),
  idmodele integer references modele (idmodele),
  iddrivetype integer references drivetype (iddrivetype),
  idtransmission integer references transmission (idtransmission),
  idenergie integer references energie (idenergie),
  idoptions text[],
  photos text[]
);

create table annonce(
  idannonce serial primary key,
  descri text,
  prix real,
  datepub timestamp,
  idvoiture integer references voiture (idvoiture),
  idutilisateur varchar
);

create table favori(
  idfavori serial primary key,
  idannonce integer references annonce (idannonce),
  idutilisateur varchar
);

create table options(
  idoptions serial primary key,
  nomoptions varchar,
  idtype integer references type (idtype)
);

create table validation(
  idvalidation serial primary key,
  etat integer,
  datemodif timestamp,
  idannonce integer references annonce (idannonce)
);

create table commission(
    idcommission serial primary key,
    valeur real,
    date date
);

create table tresorerie(
    idtresorerie serial primary key,
    idannonce varchar,
    entre real,
    sortie real,
    datemouvement timestamp
);

create view v_gain_par_mois as
    select
        ROW_NUMBER() OVER (ORDER BY extract(year from datemouvement), extract(month from datemouvement)) AS id, 
        extract(year from datemouvement) as annee,
        extract(month from datemouvement) as mois,
        sum(entre) as prix
    from 
        tresorerie
    group by 
        annee, mois
    order by 
        extract(year from datemouvement) desc, extract(month from datemouvement) desc;