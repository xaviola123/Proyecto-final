CREATE TABLE `agencia`.`vuelos` (
  `id_vuelos` INT NOT NULL AUTO_INCREMENT,
  `compania` VARCHAR(255) NULL,
  `fecha_vuelo` DATE NULL,
  `precio` DOUBLE NULL,
  `plazas_disponibles` INT NULL,
  PRIMARY KEY (`id_vuelos`));
