CREATE TABLE Projekti
(
nimi String(120),
pvm date
);

CREATE TABLE PPaallikko
(
etunimi String(120),
sukunimi String(120),
kayttajatunnus varchar(10)
);

CREATE TABLE Kirjaus
(
pvm date,
kesto int,
);

CREATE TABLE Kayttaja
(
etunimi String(120),
sukunimi String (120),
kayttajatunnus varchar(10)
);

CREATE TABLE Tehtava
(
nimi String(60),
kuvaus varchar(255)
);
