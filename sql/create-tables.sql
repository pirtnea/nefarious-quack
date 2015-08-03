CREATE TABLE Projekti
(
id SERIAL PRIMARY KEY,
nimi varchar(120),
pvm date
);

CREATE TABLE Paallikko
(
id SERIAL PRIMARY KEY,
etunimi varchar(120),
sukunimi varchar(120),
kayttajatunnus varchar(10)
);

CREATE TABLE Kirjaus
(
id SERIAL PRIMARY KEY,
pvm date,
kesto int
);

CREATE TABLE Kayttaja
(
id SERIAL PRIMARY KEY,
etunimi varchar(120),
sukunimi varchar(120),
kayttajatunnus varchar(10),
rooli varchar(10)
);

CREATE TABLE Tehtava
(
id SERIAL PRIMARY KEY,
nimi varchar(60),
kuvaus varchar(255)
);
