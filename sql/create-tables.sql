CREATE TABLE Projekti
(
id SERIAL PRIMARY KEY,
projektin_nimi varchar(120) not null UNIQUE,
pvm date not null
);

CREATE TABLE Kirjaus
(
id SERIAL PRIMARY KEY,
pvm date not null,
kesto int not null,
tehtavan_nimi varchar(60) not null,
kayttajatunnus varchar(10) not null,
projektin_nimi varchar(120) not null,
CONSTRAINT fk_tehtavan_nimi FOREIGN KEY (TEHTAVAN_NIMI) REFERENCES Tehtava (TEHTAVAN_NIMI),
CONSTRAINT fk_kayttajatunnus FOREIGN KEY (KAYTTAJATUNNUS) REFERENCES Kayttajan_projektit (KAYTTAJATUNNUS),
CONSTRAINT fk_projektin_nimi FOREIGN KEY (PROJEKTIN_NIMI) REFERENCES Kayttajan_projektit (PROJEKTIN_NIMI)
);

CREATE TABLE Kayttaja
(
id SERIAL PRIMARY KEY,
etunimi varchar(120) not null,
sukunimi varchar(120) not null,
kayttajatunnus varchar(10) not null UNIQUE,
salasana varchar(255) not null,
rooli varchar(10)
);

CREATE TABLE Tehtava
(
id SERIAL PRIMARY KEY,
tehtavan_nimi varchar(60) not null UNIQUE,
kuvaus varchar(255)
);

CREATE TABLE Kayttajan_projektit
(
projektin_nimi varchar(120) not null UNIQUE,
kayttajatunnus varchar(10) not null UNIQUE,
CONSTRAINT pk_kayttajan_projektit PRIMARY KEY (KAYTTAJATUNNUS,PROJEKTIN_NIMI),
CONSTRAINT fk_kayttajatunnus FOREIGN KEY (KAYTTAJATUNNUS) REFERENCES Kayttaja (KAYTTAJATUNNUS),
CONSTRAINT fk_projekti FOREIGN KEY (PROJEKTIN_NIMI) REFERENCES Projekti(PROJEKTIN_NIMI)
);


