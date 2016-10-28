-- ----------------------------
-- Table structure for `productbrand`
-- ----------------------------
DROP TABLE IF EXISTS `productbrand`;
CREATE TABLE `productbrand` (
  `code` varchar(36) NOT NULL,
  `logopath` varchar(80) DEFAULT NULL,
  `name` varchar(40) NOT NULL,
  `visible` bit(1) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `producttype`
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `visible` bit(1) NOT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeid`),
  KEY `FKA8168A94F2D4048` (`parentid`),
  CONSTRAINT `FKA8168A94F2D4048` FOREIGN KEY (`parentid`) REFERENCES `producttype` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=7443 DEFAULT CHARSET=utf8;