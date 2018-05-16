CREATE TABLE `LogisticsRecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logisticsStatus` varchar(255) NOT NULL,
  `outboundTime` datetime NOT NULL,
  `signedTime` datetime NOT NULL,
  `deliveryMan` varchar(255) NOT NULL,
  `orderId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;