CREATE TABLE UTENTE(
	nome char(20),
        cognome char(30),
        username char(50) primary key unique,
        password char(30),
	cf  char(30) unique,
	isresponsabile int(2));      

CREATE TABLE TIPOABBONAMENTO(
	nome char(30) primary key unique,
	durataminuti long,
	duratastring char(40),
	costo double,
	isabbonamento int(2));

CREATE TABLE ABBONAMENTO(
	utente char (50),
        data_acquisto long,
	id char(50) primary key,
        tipoabbonamento char(40),
	datatimbratura long,
        foreign key (utente) references utente (username) on update cascade,
	foreign key (tipoabbonamento) references tipoabbonamento (nome) on update cascade);

CREATE TABLE NEWS(
	titolo char(255),
        testo char(255),
        id char(50) primary key,
        autore char(50),
        foreign key (autore) references utente (username) on update cascade);
	
CREATE TABLE RECLAMO(
	titolo char(255),
        testoreclamo char(255),
        testorisposta char(255),
	id char(50) primary key,
        utente char(50),
	impiegato char(50),
        foreign key (utente) references utente (username) on update cascade,
        foreign key (impiegato) references utente (username) on update cascade);