ALTER TABLE `user`
ADD COLUMN `username` VARCHAR(255) NULL AFTER `email`,
ADD COLUMN `password` VARCHAR(255) NULL AFTER `username`,
ADD COLUMN `lastPasswordReset` DATETIME NULL AFTER `password`,
ADD COLUMN `authorities` VARCHAR(255) NULL AFTER `lastPasswordReset`;
