ALTER TABLE `page` ADD COLUMN `user_id` BIGINT(20) UNSIGNED NOT NULL AFTER `name`;
ALTER TABLE `page`
ADD INDEX `fk_page_creator_idx` (`user_id` ASC);
ALTER TABLE `page`
ADD CONSTRAINT `fk_page_creator`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;