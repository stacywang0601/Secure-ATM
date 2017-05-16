-- MySQL dump 10.11
--
-- Host: localhost    Database: boa
-- ------------------------------------------------------
--
-- Current Database: `boa`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `boa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `boa`;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(11) default NULL,
  `cardnum` char(8) default NULL,
  `password` char(35) default NULL,
  `account` double default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'43670001','e10adc3949ba59abbe56e057f20f883e',37889),(2,'43670002','111111',5643.5);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

