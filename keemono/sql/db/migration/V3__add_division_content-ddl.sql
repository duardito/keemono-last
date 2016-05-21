CREATE TABLE `zcontent` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `uuid` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `content` VARCHAR(2000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC));

CREATE TABLE `division` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `uuid` VARCHAR(45) NOT NULL,
  `content_id` BIGINT(20) UNSIGNED NOT NULL,
  `schema` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC));

ALTER TABLE `division`
ADD INDEX `fk_division_content_idx` (`content_id` ASC);
ALTER TABLE .`division`
ADD CONSTRAINT `fk_division_content`
  FOREIGN KEY (`content_id`)
  REFERENCES `zcontent` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE `division`
ADD COLUMN `layout_id` BIGINT(20) UNSIGNED NOT NULL AFTER `schema`,
ADD INDEX `fk_division_layout_idx` (`layout_id` ASC);
ALTER TABLE `division`
ADD CONSTRAINT `fk_division_layout`
  FOREIGN KEY (`layout_id`)
  REFERENCES `layout` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE `division`
DROP FOREIGN KEY `fk_division_content`;
ALTER TABLE `division`
CHANGE COLUMN `content_id` `content_id` BIGINT(20) UNSIGNED NULL ;
ALTER TABLE `division`
ADD CONSTRAINT `fk_division_content`
  FOREIGN KEY (`content_id`)
  REFERENCES `zcontent` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

