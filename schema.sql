CREATE TABLE IF NOT EXISTS ryhma (
  ryhmaid int NOT NULL AUTO_INCREMENT,
  ryhmanimi varchar(255),
  PRIMARY KEY (id);
);

CREATE TABLE IF NOT EXISTS kysymys (
  id int NOT NULL AUTO_INCREMENT,
  ryhmaid int NOT NULL,
  kysymys varchar(255),
  PRIMARY KEY (id),
  FOREIGN KEY (ryhmaid) REFERENCES ryhma(ryhmaid)
);

INSERT INTO ryhma (ryhmaid, ryhmanimi) VALUES(1, "tiimi4");
INSERT INTO ryhma (ryhmaid, ryhmanimi) VALUES(2, "tikiboxi");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(1, 1, "Oletko ajatellut tulla pyörällä kouluun?");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(2, 1, "Mikä houkuttaisi pyöräilyn valitsemisen koulumatkalle?");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(3, 1, "Miten koulu voisi tukea pyöräilyä?");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(4, 2, "Käytätkö koulun tietokoneita?");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(5, 2, "Jos käytät niin miksi / jos et käytä niin miksi et?");
INSERT INTO kysymys (id, ryhmaid, kysymys) VALUES(6, 2, "Kehitysehdotukset?");
