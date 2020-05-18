
CREATE TABLE IF NOT EXISTS usuarios (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
  email VARCHAR(30),
  INDEX(username)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS razonamiento (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuarioraz VARCHAR(30),
  fechallenado DATE,
  resultado INT(6),
  INDEX(usuarioraz)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS personalidad (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuarioper VARCHAR(30),
  fechallenado DATE,
  extroversion INT(6),
  creatividad INT(6),
  responsabilidad INT(6),
  neurotismo INT(6),
  afabilidad INT(6),
  INDEX(usuarioper)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS identidad (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuarioide VARCHAR(30),
  fechallenado DATE,
  compromiso INT(6),
  identificacion INT(6),
  anchoexplo INT(6),
  profexplo INT(6),
  flexibilidad INT(6),
  dudas INT(6),
  INDEX(usuarioide)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS decision (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  usuariodec VARCHAR(30),
  fuente VARCHAR(30),
  fechallenado DATE,
  racional INT(6),
  intuitivo INT(6),
  dependiente INT(6),
  evasivo INT(6),
  espontaneo INT(6),
  INDEX(usuariodec)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS promedios (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fechallenado DATE,
  habilidad INT(6),
  extroversion INT(6),
  creatividad INT(6),
  responsabilidad INT(6),
  inestabilidad INT(6),
  afabilidad INT(6),
  compromiso INT(6),
  identificacion INT(6),
  anchoexplo INT(6),
  profexplo INT(6),
  flexibilidad INT(6),
  dudas INT(6),
  racional INT(6),
  intuitivo INT(6),
  dependiente INT(6),
  evasivo INT(6),
  espontaneo INT(6),
  INDEX(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS carrera (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nivel VARCHAR(30),
  nombre VARCHAR(100),
  dpto VARCHAR(30),
  localidad VARCHAR(30),
  institucion VARCHAR(100),
  sigla VARCHAR(10),
  area VARCHAR(30),
  pago VARCHAR(30),
  INDEX(id)
) engine=InnoDB;
