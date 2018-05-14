

CREATE TABLE `Inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  `lockedCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
