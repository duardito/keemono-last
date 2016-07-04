CREATE TABLE `page_content` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `page_id` BIGINT(20) UNSIGNED NOT NULL,
  `layout_id` BIGINT(20) UNSIGNED NOT NULL,
  `content_div` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_page_idx` (`page_id` ASC),
  INDEX `fk_page_content_layout_idx` (`layout_id` ASC),
  UNIQUE INDEX `index4` (`page_id` ASC, `layout_id` ASC, `content_div` ASC),
  CONSTRAINT `fk_page_content_page`
    FOREIGN KEY (`page_id`)
    REFERENCES `page` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_page_content_layout`
    FOREIGN KEY (`layout_id`)
    REFERENCES `layout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `zcontent` (`id`, `uuid`, `name`, `content`, `user_id`) VALUES (1,'content:e5cb5381-9602-4360-ae4c-5433879d3189','test content','aqui podemos poner loq ue queremaos, por ejemllpo una imagen que ilusta esto.\n<img src=\'http://samuris.com/uploads/monthly_11_2012/post-1-0-94607700-1352200477.png\'>\n\nAqui justo arriba deberiamos ver una image.',1);
INSERT INTO `layout` (`id`, `name`, `data`, `user_id`, `uuid`) VALUES (1,'test','<div class=\'row\'>\n  <div id=\'1\' ng-style=\'visualization\' class=\'col-md-4 editable\'>\n        <a  href=\"#addContent\">\n          <span class=\"glyphicon glyphicon-plus\"></span>\n        </a>\n        <a  href=\"#editContent\">\n          <span class=\"glyphicon glyphicon-edit\"></span>\n        </a>\n        <a  href=\"#removeContent\">\n          <span class=\"glyphicon glyphicon-remove\"></span>\n        </a>\n        </div>\n   <div id=\'2\' ng-style=\'visualization\' class=\'col-md-8 editable\'> \n      <a href=\"#addContent\">\n          <span class=\"glyphicon glyphicon-plus\"></span>\n        </a>\n        <a  href=\"#editContent\">\n          <span class=\"glyphicon glyphicon-edit\"></span>\n        </a>\n        <a  href=\"#removeContent\">\n          <span class=\"glyphicon glyphicon-remove\"></span>\n        </a>\n        </div>\n </div> \n<div class=\'row\'>\n   <div id=\'3\' ng-style=\'visualization\' class=\'col-md-4 editable\'>\n     <a href=\"#addContent\">\n          <span class=\"glyphicon glyphicon-plus\"></span>\n        </a>\n        <a  href=\"#editContent\">\n          <span class=\"glyphicon glyphicon-edit\"></span>\n        </a>\n        <a  href=\"#removeContent\">\n          <span class=\"glyphicon glyphicon-remove\"></span>\n        </a>\n        </div>\n</div>',1,'layout:86add9ba-bc9f-4f8e-b21f-210769d65e42');
INSERT INTO `page` (`id`, `layout_id`, `uuid`, `name`, `user_id`) VALUES (1,1,'page:d3ef4dc2-c69b-4262-a2f2-554107627efe','test',1);
