# noinspection SqlNoDataSourceInspectionForFile

/*
 * Maak de API gebruiker aan die we vanuit onze Spring JPA applicatie gebruiken (zie application.properties in project resources)
 */
DROP USER IF EXISTS 'form-demo-app-user-rw'@'localhost';
CREATE USER IF NOT EXISTS 'form-demo-app-user-rw'@'localhost' IDENTIFIED BY '#FuckingVeiligWachtwoord111';

/*
 * Set optimaal bestandsformaat voor onze app
 */
SET GLOBAL innodb_file_per_table=1;
SET GLOBAL innodb_file_format=Barracuda;

/*
 * Database
 */
CREATE DATABASE IF NOT EXISTS `formdemo`;

/*
 * Form tabel (zie bean model/Form.java)
 */
CREATE TABLE IF NOT EXISTS `formdemo`.`Form` (

    /*
     * ID van gebruiker (PK)
     */
    `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,

    /*
     * E-mailadres van gebruiker (UQ)
     */
    `email`       VARCHAR(320) NOT NULL,

    /*
     * Wachtwoord dat eigenlijk gehashed moet worden... lol.
     */
    `password`    VARCHAR(256) NOT NULL,

    /*
     * Of de gebruiker akkoord gaat met de voorwaarden
     */
    `accept`      BOOLEAN NOT NULL,

    /*
     * Timestamps wanneer het gesubmit is
     */
    `created`     TIMESTAMP NOT NULL DEFAULT now(),
    `updated`     TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now(),

    PRIMARY KEY (`id`),
    CONSTRAINT uc_email UNIQUE (`email`)

) AUTO_INCREMENT=0
  ROW_FORMAT=COMPRESSED
  ENGINE = InnoDB
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

/*
 * TODO restrict permissions
 */
GRANT SELECT, INSERT ON `formdemo`.`Form` TO 'form-demo-app-user-rw'@'localhost';
