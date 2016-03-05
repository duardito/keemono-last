CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `uuid` varchar(36) NOT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB;

CREATE TABLE `layout` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `data` varchar(2000) NOT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_layout_user_idx` (`user_id`),
  CONSTRAINT `fk_layout_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `page` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `layout_id` bigint(20) unsigned NOT NULL,
  `uuid` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`uuid`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_layout_idx` (`layout_id`),
  CONSTRAINT `fk_layout` FOREIGN KEY (`layout_id`) REFERENCES `layout` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;


