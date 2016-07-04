ALTER TABLE `page_content`
ADD COLUMN `uuid` VARCHAR(45) NOT NULL AFTER `content_id`,
ADD UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC);
