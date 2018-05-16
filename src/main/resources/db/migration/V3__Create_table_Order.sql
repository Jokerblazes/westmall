CREATE TABLE `Order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `totalPrice` decimal(10,0) NOT NULL,
  `createTime` datetime NOT NULL,
  `finishTime` datetime,
  `paidTime` datetime,
  `withdrawnTime` datetime,
  `status` varchar(255) NOT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;