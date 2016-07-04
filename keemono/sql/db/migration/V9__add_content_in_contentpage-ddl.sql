ALTER TABLE `page_content`
ADD COLUMN `content_id` BIGINT(20) UNSIGNED NOT NULL AFTER `content_div`,
ADD INDEX `fk_page_content_content_idx` (`content_id` ASC);
ALTER TABLE `page_content`
ADD CONSTRAINT `fk_page_content_content`
  FOREIGN KEY (`content_id`)
  REFERENCES `zcontent` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;