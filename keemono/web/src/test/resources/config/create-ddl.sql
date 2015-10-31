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


insert into user(id,name,uuid,lastname,email) values (1, 'edu','c695b78b-7218-4e53-897b-51d29c250965','frades','eduard.frades@gmail.com');
insert into user(id,name,uuid,lastname,email) values (2,'juan','1063ac98-89c4-447c-aa08-c8ce354f809a','perez','juan.perez@gmail.com');


INSERT INTO layout(id,name,data,user_id,uuid ) VALUES (1,'two-layout','<div id="2" class="row"><div id="3" class="col-xs-4"><div id="4" class="dragable"></div></div><div id="5" class="col-xs-8"><div id="6" class="dragable"></div></div></div>',1,'c695b78b-7218-4e53-897b-51d29c250911');
