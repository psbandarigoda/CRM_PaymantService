CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `method` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
