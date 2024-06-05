CREATE TABLE `agencia`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(255) NULL,
  `dni` VARCHAR(255) NULL,
  `id_vuelo` INT NULL,
  `id_hotel` INT NULL,
  `total_personas` INT NULL,
  PRIMARY KEY (`id_reserva`));
