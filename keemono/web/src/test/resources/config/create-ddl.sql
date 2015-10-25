CREATE TABLE `layout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255)  DEFAULT NULL,
  `valores` varchar(2000)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO layout(name, valores) VALUES ('two-layout','<div id="2" class="row"><div id="3" class="col-xs-4"><div id="4" class="dragable"></div></div><div id="5" class="col-xs-8"><div id="6" class="dragable"></div></div></div>');
