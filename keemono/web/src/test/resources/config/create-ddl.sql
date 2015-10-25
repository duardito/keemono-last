CREATE TABLE `layout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)  DEFAULT NULL,
  `values` varchar(2000)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
