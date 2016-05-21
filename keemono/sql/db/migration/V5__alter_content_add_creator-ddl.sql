ALTER TABLE `zcontent`
ADD COLUMN `user_id` BIGINT(20) UNSIGNED NOT NULL AFTER `content`,
ADD INDEX `fk_content_creator_idx` (`user_id` ASC);
ALTER TABLE `zcontent`
ADD CONSTRAINT `fk_content_creator`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;