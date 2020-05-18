DROP TABLE vet_specialties IF EXISTS;
DROP TABLE vets IF EXISTS;
DROP TABLE specialties IF EXISTS;
DROP TABLE visits IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE owners IF EXISTS;


CREATE TABLE vets (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX vets_last_name ON vets (last_name);

CREATE TABLE specialties (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX specialties_name ON specialties (name);

CREATE TABLE vet_specialties (
  vet_id       INTEGER NOT NULL,
  specialty_id INTEGER NOT NULL
);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_vets FOREIGN KEY (vet_id) REFERENCES vets (id);
ALTER TABLE vet_specialties ADD CONSTRAINT fk_vet_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES specialties (id);

CREATE TABLE types (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX types_name ON types (name);

CREATE TABLE owners (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR_IGNORECASE(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20)
);
CREATE INDEX owners_last_name ON owners (last_name);

CREATE TABLE pets (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);
ALTER TABLE pets ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES owners (id);
ALTER TABLE pets ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES types (id);
CREATE INDEX pets_name ON pets (name);

CREATE TABLE visits (
  id          INTEGER IDENTITY PRIMARY KEY,
  pet_id      INTEGER NOT NULL,
  visit_date  DATE,
  description VARCHAR(255)
);
ALTER TABLE visits ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES pets (id);
CREATE INDEX visits_pet_id ON visits (pet_id);

CREATE TABLE usuarios (
                          id INTEGER IDENTITY PRIMARY KEY,
                          username VARCHAR(30),
                          password VARCHAR(30),
                          ueducativa VARCHAR(30),
                          nombre VARCHAR(80),
                          apellidos VARCHAR(80),
                          fechanac DATE,
                          sexo VARCHAR(20),
                          grado VARCHAR(10),
                          nivel VARCHAR(30),
                          dpto VARCHAR(30),
                          provincia VARCHAR(30),
                          localidad VARCHAR(30),
                          descripcion VARCHAR(255),
                          email VARCHAR(30)
);
CREATE INDEX usuarios_username ON usuarios (username);

CREATE TABLE razonamiento (
                           id INTEGER IDENTITY PRIMARY KEY,
                           usuarioraz VARCHAR(30),
                           fechallenado DATE,
                           resultado INTEGER
);
CREATE INDEX razonamiento_usuarioraz ON razonamiento (usuarioraz);

CREATE TABLE personalidad (
                              id INTEGER IDENTITY PRIMARY KEY,
                              usuarioper VARCHAR(30),
                              fechallenado DATE,
                              extroversion INTEGER,
                              creatividad INTEGER,
                              responsabilidad INTEGER,
                              neurotismo INTEGER,
                              afabilidad INTEGER
);
CREATE INDEX personalidad_usuarioper ON personalidad (usuarioper);

CREATE TABLE identidad (
                           id INTEGER IDENTITY PRIMARY KEY,
                           usuarioide VARCHAR(30),
                           fechallenado DATE,
                           compromiso INTEGER,
                           identificacion INTEGER,
                           anchoexplo INTEGER,
                           profexplo INTEGER,
                           flexibilidad INTEGER,
                           dudas INTEGER
);
CREATE INDEX identidad_usuarioide ON identidad (usuarioide);

CREATE TABLE decision (
                          id INTEGER IDENTITY PRIMARY KEY,
                          usuariodec VARCHAR(30),
                          fuente VARCHAR(30),
                          fechallenado DATE,
                          racional INTEGER,
                          intuitivo INTEGER,
                          dependiente INTEGER,
                          evasivo INTEGER,
                          espontaneo INTEGER
);
CREATE INDEX decision_usuariodec ON decision (usuariodec);


CREATE TABLE promedios (
                           id INTEGER IDENTITY PRIMARY KEY,
                           fechallenado DATE,
                           habilidad INTEGER,
                           extroversion INTEGER,
                           creatividad INTEGER,
                           responsabilidad INTEGER,
                           inestabilidad INTEGER,
                           afabilidad INTEGER,
                           compromiso INTEGER,
                           identificacion INTEGER,
                           anchoexplo INTEGER,
                           profexplo INTEGER,
                           flexibilidad INTEGER,
                           dudas INTEGER,
                           racional INTEGER,
                           intuitivo INTEGER,
                           dependiente INTEGER,
                           evasivo INTEGER,
                           espontaneo INTEGER
);
CREATE INDEX promedios_id ON promedios (id);

CREATE TABLE carrera (
                         id INTEGER IDENTITY PRIMARY KEY,
                         nivel VARCHAR(30),
                         nombre VARCHAR(100),
                         dpto VARCHAR(30),
                         localidad VARCHAR(30),
                         institucion VARCHAR(100),
                         sigla VARCHAR(10),
                         area VARCHAR(30),
                         pago VARCHAR(30)
);
CREATE INDEX carrera_id ON carrera (id);
