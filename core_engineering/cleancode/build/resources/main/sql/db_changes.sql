CREATE TABLE `jts`.`people` (
  `idpeople` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`idpeople`));


CREATE TABLE `jts`.`movie` (
  `idmovie` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `rented` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idmovie`));


CREATE TABLE `jts`.`movie_people` (
  `idmovie_people` INT NOT NULL AUTO_INCREMENT,
  `id_movie` INT NOT NULL,
  `id_people` INT NOT NULL,
  PRIMARY KEY (`idmovie_people`, `id_movie`, `id_people`),
  INDEX `idmovie_fk_idx` (`id_movie` ASC),
  INDEX `idpeople_fk_idx` (`id_people` ASC),
  CONSTRAINT `idmovie_fk`
    FOREIGN KEY (`id_movie`)
    REFERENCES `jts`.`movie` (`idmovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idpeople_fk`
    FOREIGN KEY (`id_people`)
    REFERENCES `jts`.`people` (`idpeople`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
