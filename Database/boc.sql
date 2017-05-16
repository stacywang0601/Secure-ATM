-- MySQL dump 10.11
--
-- Host: localhost    Database: boc
-- ------------------------------------------------------
--
-- Current Database: `boc`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `boc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `boc`;

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
INSERT INTO `accounts` VALUES (1,'95580001','c33367701511b4f6020ec61ded352059',1000),(2,'95580002','e3ceb5881a0a1fdaad01296d7554868d',5000);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

