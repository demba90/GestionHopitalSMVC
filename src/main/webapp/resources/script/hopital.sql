SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `hopital` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hopital` ;

-- -----------------------------------------------------
-- Table `hopital`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `prenom` VARCHAR(45) NULL,
  `nom` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `profil` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hopital`.`medecin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`medecin` (
  `matricule` INT NOT NULL AUTO_INCREMENT,
  `specialite` VARCHAR(45) NULL,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`matricule`),
  INDEX `fk_medecin_user1_idx` (`user_iduser` ASC))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `hopital`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`patient` (
  `idpatient` INT NOT NULL AUTO_INCREMENT,
  `prenom` VARCHAR(45) NULL,
  `nom` VARCHAR(45) NULL,
  `pato` VARCHAR(45) NULL,
  PRIMARY KEY (`idpatient`))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `hopital`.`rendezvous`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`rendezvous` (
  `idrendezvous` INT NOT NULL AUTO_INCREMENT,
  `jour` VARCHAR(45) NULL,
  `heure` VARCHAR(45) NULL,
  `medecin_matricule` INT NOT NULL,
  `patient_idpatient` INT NOT NULL,
  PRIMARY KEY (`idrendezvous`),
  INDEX `fk_rendezvous_medecin_idx` (`medecin_matricule` ASC),
  INDEX `fk_rendezvous_patient1_idx` (`patient_idpatient` ASC))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `hopital`.`secretaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`secretaire` (
  `idsecretaire` INT NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idsecretaire`),
  INDEX `fk_secretaire_user1_idx` (`user_iduser` ASC))
ENGINE = MyISAM;


-- -----------------------------------------------------
-- Table `hopital`.`diagnostique`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hopital`.`diagnostique` (
  `resultat` VARCHAR(45) NULL,
  `etat` VARCHAR(45) NULL,
  `rendezvous_idrendezvous` INT NOT NULL,
  INDEX `fk_diagnostique_rendezvous1_idx` (`rendezvous_idrendezvous` ASC))
ENGINE = MyISAM;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
